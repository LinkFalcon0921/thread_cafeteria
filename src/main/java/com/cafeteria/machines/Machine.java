package com.cafeteria.machines;

import com.cafeteria.complements.EComplementType;
import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.IContainer;
import com.cafeteria.containers.IContainerSize;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.exceptions.containers.creators.IssueMachineExceptionCreator;
import com.cafeteria.exceptions.stocks.UndoneException;
import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.IGrain;
import com.cafeteria.machines.stocks.StockMachine;
import com.cafeteria.managers.builders.IContainerBuilder;
import com.cafeteria.managers.factories.getters.containers.IGrainContainerGetterManager;
import com.cafeteria.managers.factories.getters.mixers.IMixerGetter;
import com.cafeteria.managers.mixes.IGrainMixDetails;
import com.cafeteria.managers.mixes.IMixer;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

/**
 * Generics Param<br/>
 * * Enum container size<br/>
 * * MixerFactory class<br/>
 * * Enum grain mixer<br/>
 * * Grain class
 */
public abstract class Machine
        <MIXER extends IMixer<E_MIX, G>,
                E_MIX extends IGrainMixDetails,
                G extends IGrain>
        implements IMachine {
    protected final StockMachine stocks;
    protected final MIXER mixer;
    protected final IMixerGetter<E_MIX> mixerGetter;
    protected final IGrainContainerGetterManager containerGetterFactory;
    protected final EGrainsType grainsType;
    protected static IssueMachineExceptionCreator EXCEPTION_CREATOR;

    public Machine(EGrainsType grainsType, IMixerGetter<E_MIX> mixerGetter, MIXER mixer,
                   IGrainContainerGetterManager containerGetterFactory) {
        EXCEPTION_CREATOR = IssueMachineExceptionCreator.getCreator();

        this.mixer = mixer;
        this.mixerGetter = mixerGetter;
        this.grainsType = grainsType;
        this.containerGetterFactory = containerGetterFactory;

        this.stocks = new StockMachine();
    }

    public <C_SIZE extends IContainerSize, BC extends IContainerBuilder<C, C_SIZE>, C extends IContainer<C_SIZE>>
    C prepareContainer(@NonNull BC builder, @NonNull EContainerType containerType,
                       @NonNull EContainerSize containerSize,
                       @NonNull List<IComplement> complements)
            throws IssueMachineException, UndoneException {

        IContainerSize containerDetails = this.containerGetterFactory
                .getGrainContainerDetails(containerType, containerSize);

        // Get the number of grains required
        Optional<G> grainRequired = this.stocks
                .getStock(this.grainsType, containerDetails)
                .map(getMapper());

        E_MIX requiredMixValues = this.mixerGetter.getMixerOf(containerSize);

        final float grainAmount = this.mixer.mixGrains(requiredMixValues, grainRequired);

        // Create the container
        var container = builder
                .setSize(containerSize)
                .setMaxAmount(containerDetails.getMaxContent())
                .setActualAmount(grainAmount)
                .prepare();

        // Add the grains.
        container.setGrains(grainRequired.orElseThrow());

        //Add Complements
        addComplements(container, complements);

        return container;
    }

    protected <C_SIZE extends IContainerSize, C extends IContainer<C_SIZE>>
    void addComplements(C container, List<IComplement> complements)
            throws IssueMachineException {

        if (Objects.isNull(complements) || complements.isEmpty()) {
            return;
        }

        for (IComplement complement : complements) {
            final EComplementType type = complement.getType();

            if (!this.stocks.hasStockOf(type)) {
                throw EXCEPTION_CREATOR.createNoStockOfException(type);
            }

            container.addComplement(complement);
        }
    }

    @Override
    public boolean fillGrainStock(IGrain g) {
        return this.stocks.addStock(g);
    }

    @Override
    public boolean fillComplementStock(IComplement c) {
        return this.stocks.addStock(c);
    }

    @Override
    public boolean fillGrainStock(List<IGrain> gList) {
        return gList.stream().allMatch(this::fillGrainStock);
    }

    @Override
    public boolean fillComplementStock(List<IComplement> cList) {
        return cList.stream().allMatch(this::fillComplementStock);
    }

    @Override
    public void restart() throws UndoneException {
        this.stocks.cleanStocks();
    }

    @NotNull
    protected abstract Function<IGrain, G> getMapper();
}
