package com.cafeteria.machines.coffee;

import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.EContainerSize;
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
import com.cafeteria.managers.validators.coffee.CoffeeGrainsValidator;
import com.cafeteria.managers.validators.complements.ComplementValidator;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public class CoffeeMachine implements ICoffeeCupMachine, ICoffeeGlassMachine {
    private final CoffeeGrainsValidator coffeeRuler;
    private final CoffeeMixer mixer;
    private final StockMachine stocks;
    private final ComplementValidator complementValidator;

    public CoffeeMachine() {
        this.coffeeRuler = new CoffeeGrainsValidator();
        this.mixer = new CoffeeMixer();
        this.stocks = new StockMachine();
        complementValidator = new ComplementValidator();
    }

    @Override
    public CoffeeCup prepareCup(EContainerSize size, List<IComplement> complements)
            throws IssueMachineException {

        checkIngredients(size, complements);

        return prepareContainer(CoffeeCupContainerBuilder.builder(), size);
    }

    @Override
    public CoffeeGlass prepareGlass(EContainerSize size, List<IComplement> complements)
            throws IssueMachineException {

        checkIngredients(size, complements);

        return prepareContainer(CoffeeGlassContainerBuilder.builder(), size);
    }

    private void checkIngredients(EContainerSize size, final List<IComplement> complements) throws IssueMachineException {
        // TODO: 8/6/2023 capture exceptions
        this.coffeeRuler.checkGrain(this.stocks, size);
        this.complementValidator.checkIngredients(this.stocks, complements);
    }

    private <B extends IContainerBuilder<C, ES>, ES extends Enum<ES>, C extends IContainer<ES>>
    C prepareContainer(@NonNull B builder, EContainerSize size) {

        // Set amount of coffee
        final ECoffeeMix coffeeMixer = ECoffeeMix.getBySize(size);
        Optional<Coffee> coffee = this.stocks.getStock(EGrainsType.CAFE);

        final float amountCoffee = this.mixer.mixGrains(coffeeMixer, coffee.get());

        // Create the container
        C container = builder
                .setSize(size)
                .setMaxAmount(amountCoffee)
                .setActualAmount(amountCoffee)
                .prepare();

        container.setGrains(coffee.get());

        return container;
    }
}
