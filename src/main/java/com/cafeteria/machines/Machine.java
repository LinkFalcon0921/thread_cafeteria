package com.cafeteria.machines;

import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.IContainer;
import com.cafeteria.containers.IContainerSize;
import com.cafeteria.exceptions.stocks.UndoneException;
import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.IGrain;
import com.cafeteria.machines.stocks.StockMachine;
import com.cafeteria.managers.builders.coffee.IContainerBuilder;
import com.cafeteria.managers.factories.IContainerGetter;
import com.cafeteria.managers.mixes.coffee.IMixer;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
/**Generics Param<br/>
 * * Enum container size<br/>
 * * Mixer class<br/>
 * * Enum grain mixer<br/>
 * * Grain class*/
public abstract class Machine
        <EC_SIZE extends IContainerSize,
                MIXER extends IMixer<E_MIX, G>,
                E_MIX extends Enum<E_MIX>,
                G extends IGrain>
        implements IMachine {
    protected final StockMachine stocks;
    private final MIXER mixer;
    protected final Map<EContainerType, IContainerGetter<EC_SIZE>> containerGetterFactory;
    private final EGrainsType grainsType;

    public Machine(EGrainsType grainsType, MIXER mixer, Map<EContainerType,
            IContainerGetter<EC_SIZE>> containerGetterFactory) {
        this.mixer = mixer;
        this.containerGetterFactory = containerGetterFactory;
        this.grainsType = grainsType;
        stocks = new StockMachine();
    }

    public <BC extends IContainerBuilder<C, EC_SIZE>, C extends IContainer<EC_SIZE>>
    C prepareContainer(@NonNull BC builder, EContainerType containerType,
                       EContainerSize containerSize,
                       E_MIX requiredMixValues, @NonNull List<IComplement> complements) {

        // Get the number of grains required
        Optional<G> grainRequired = this.stocks
                .getStock(grainsType, containerType, containerSize)
                .map(getMapper());

        final float grainAmount = this.mixer.mixGrains(requiredMixValues, grainRequired);

        // Create the container
        var container = builder.setSize(containerSize)
                .setMaxAmount(grainAmount)
                .setActualAmount(grainAmount)
                .prepare();

        // Add the grains.
        container.setGrains(grainRequired.orElseThrow());

        //Add Complements
        complements.forEach(container::addComplement);

        return container;
    }

    @Override
    public boolean fillGrainStock(IGrain g) {
        return this.stocks.addStock(g);
    }

    @Override
    public boolean fillComponentStock(IComplement c) {
        return this.stocks.addStock(c);
    }

    @Override
    public boolean fillGrainStock(List<IGrain> gList) {
        return gList.stream().allMatch(this::fillGrainStock);
    }

    @Override
    public boolean fillComponentStock(List<IComplement> cList) {
        return cList.stream().allMatch(this::fillComponentStock);
    }

    @Override
    public void restart() throws UndoneException {
        this.stocks.cleanStocks();
    }

    @NotNull
    protected abstract Function<IGrain, G> getMapper();
}
