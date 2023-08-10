package com.cafeteria.machines.coffee;

import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.IContainer;
import com.cafeteria.containers.coffee.CoffeeCup;
import com.cafeteria.containers.coffee.CoffeeGlass;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.exceptions.stocks.UndoneException;
import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.IGrain;
import com.cafeteria.grains.coffee.Coffee;
import com.cafeteria.machines.stocks.StockMachine;
import com.cafeteria.managers.builders.coffee.CoffeeCupContainerBuilder;
import com.cafeteria.managers.builders.coffee.CoffeeGlassContainerBuilder;
import com.cafeteria.managers.builders.coffee.IContainerBuilder;
import com.cafeteria.managers.mixes.coffee.CoffeeMixer;
import com.cafeteria.managers.mixes.coffee.ECoffeeMix;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class CoffeeMachine implements ICoffeeCupMachine, ICoffeeGlassMachine {

    protected static final Function<IGrain, Coffee> FUNCTION_CASTER = Coffee.class::cast;
    private final CoffeeMixer mixer;
    private final StockMachine stocks;

    public CoffeeMachine() {
        this.mixer = new CoffeeMixer();
        this.stocks = new StockMachine();
    }

    @Override
    public CoffeeCup prepareCup(EContainerSize size, List<IComplement> complements) throws IssueMachineException {
        return prepareContainer(CoffeeCupContainerBuilder.builder(), EContainerType.CUP, size, complements);
    }

    @Override
    public CoffeeGlass prepareGlass(EContainerSize size, List<IComplement> complements) throws IssueMachineException {
        return prepareContainer(CoffeeGlassContainerBuilder.builder(), EContainerType.GLASS, size, complements);
    }

    private <B extends IContainerBuilder<C, ES>, ES extends Enum<ES>, C extends IContainer<ES>>
    C prepareContainer(@NonNull B builder, EContainerType containerType, EContainerSize containerSize,
                       @NonNull List<IComplement> complements) {

        // Get the amount of coffee required
        Optional<Coffee> coffeeRequired = this.stocks
                .getStock(EGrainsType.COFFEE, containerType, containerSize)
                .map(FUNCTION_CASTER);

        final ECoffeeMix coffeeMixer = ECoffeeMix.getBySize(containerSize);
        final float amountCoffee = this.mixer.mixGrains(coffeeMixer, coffeeRequired);

// TODO: 8/7/2023 Set the maxContent based the IContainerSize
// Create the container
        var container = builder.setSize(containerSize)
                .setMaxAmount(amountCoffee).setActualAmount(amountCoffee).prepare();

        // Add the grains.
        container.setGrains(coffeeRequired.orElseThrow());

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
}
