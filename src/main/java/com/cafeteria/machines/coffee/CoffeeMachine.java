package com.cafeteria.machines.coffee;

import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.EMeasureContainer;
import com.cafeteria.containers.IContainer;
import com.cafeteria.containers.sizes.coffee.ECoffeeCupSize;
import com.cafeteria.containers.sizes.coffee.ECoffeeGlassSize;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.grains.coffee.Coffee;
import com.cafeteria.machines.ICupMachine;
import com.cafeteria.managers.containers.ContainerBuilder;
import com.cafeteria.managers.mixes.coffee.CoffeeMixer;
import com.cafeteria.managers.mixes.coffee.ECoffeeMix;
import com.cafeteria.managers.validators.coffee.CoffeeGrainsValidator;

import java.util.List;

import static com.cafeteria.exceptions.containers.IMessages.Issues;

public class CoffeeMachine implements ICoffeeCupMachine, ICoffeeGlassMachine {
    private final CoffeeGrainsValidator ruler;
    private final CoffeeMixer mixer;

    public CoffeeMachine() {
        this.ruler = new CoffeeGrainsValidator();
        this.mixer = new CoffeeMixer();
    }

//    @Override
    public IContainer<ECoffeeCupSize> makeCup(EContainerSize size,
                           Coffee grains, List<IComplement> complement) throws IssueMachineException {

        checkIngredients(size, grains);

        ContainerBuilder containerBuilder = ContainerBuilder.builder();

        // Set amount of coffee
        final ECoffeeMix coffeeMixer = ECoffeeMix.getMixerBySize(size);
        final float amountCoffee = this.mixer.mixGrains(coffeeMixer, grains);

        // Create the container
        IContainer container = containerBuilder
                .setSize(size)
                .setMaxAmount(amountCoffee)
                .setActualAmount(amountCoffee)
                .build(type);

        container.setGrains(grains);

        // Add complements
        for (IComplement c : complement) {
            container.addComplement(c);
        }

        return container;
    }

    private void checkIngredients(EContainerSize size, Coffee grains) {
        if (!this.ruler.isApplicable(size, grains)) {
            throw new IssueMachineException(Issues.NOT_ENOUGH_GRAINS);
        }
    }

    public IContainer<ECoffeeGlassSize> makeGlass(EContainerSize size,
                                             Coffee grains, List<IComplement> complement) throws IssueMachineException {

        checkIngredients(size, grains);

        ContainerBuilder containerBuilder = ContainerBuilder.builder();

        // Set amount of coffee
        final ECoffeeMix coffeeMixer = ECoffeeMix.getMixerBySize(size);
        final float amountCoffee = this.mixer.mixGrains(coffeeMixer, grains);

        // Create the container
        IContainer<ECoffeeGlassSize> container = containerBuilder
                .setSize(size)
                .setMaxAmount(amountCoffee)
                .setActualAmount(amountCoffee)
                .build(EContainerType.GLASS);

        container.setGrains(grains);

        // Add complements
        for (IComplement c : complement) {
            container.addComplement(c);
        }

        return container;
    }
}
