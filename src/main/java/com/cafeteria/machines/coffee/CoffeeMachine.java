package com.cafeteria.machines.coffee;

import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.IContainer;
import com.cafeteria.containers.coffee.CoffeeCup;
import com.cafeteria.containers.coffee.CoffeeGlass;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.coffee.Coffee;
import com.cafeteria.machines.StockMachine;
import com.cafeteria.managers.builders.coffee.CoffeeCupContainerBuilder;
import com.cafeteria.managers.builders.coffee.CoffeeGlassContainerBuilder;
import com.cafeteria.managers.builders.coffee.IContainerBuilder;
import com.cafeteria.managers.mixes.coffee.CoffeeMixer;
import com.cafeteria.managers.mixes.coffee.ECoffeeMix;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public class CoffeeMachine implements ICoffeeCupMachine, ICoffeeGlassMachine {

    private final CoffeeMixer mixer;
    private final StockMachine stocks;

    public CoffeeMachine() {
        this.mixer = new CoffeeMixer();
        this.stocks = new StockMachine();
    }

    @Override
    public CoffeeCup prepareCup(EContainerSize size, List<IComplement> complements) throws IssueMachineException {
        return prepareContainer(CoffeeCupContainerBuilder.builder(), EContainerType.CUP, size);
    }

    @Override
    public CoffeeGlass prepareGlass(EContainerSize size, List<IComplement> complements) throws IssueMachineException {
        return prepareContainer(CoffeeGlassContainerBuilder.builder(), EContainerType.GLASS, size);
    }

    private <B extends IContainerBuilder<C, ES>, ES extends Enum<ES>, C extends IContainer<ES>>
    C prepareContainer(@NonNull B builder, EContainerType containerType, EContainerSize containerSize) {

        // Get the amount of coffee required
        Optional<Coffee> coffeeRequired = this.stocks.getStock(EGrainsType.COFFEE, containerType, containerSize);

        final ECoffeeMix coffeeMixer = ECoffeeMix.getBySize(containerSize);
        final float amountCoffee = this.mixer.mixGrains(coffeeMixer, coffeeRequired);

        // Create the container
        var container = builder.setSize(containerSize)
                .setMaxAmount(amountCoffee).setActualAmount(amountCoffee).prepare();

        // Add the grains.
        container.setGrains(coffeeRequired.orElseThrow());

        return container;
    }
}
