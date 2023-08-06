package com.cafeteria.machines.coffee;

import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.EMeasureContainer;
import com.cafeteria.containers.IContainer;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.grains.coffee.Coffee;
import com.cafeteria.managers.containers.ContainerBuilder;
import com.cafeteria.managers.mixes.coffee.CoffeeMixer;
import com.cafeteria.managers.mixes.coffee.ECoffeeMix;
import com.cafeteria.managers.validators.coffee.CoffeeGrainsValidator;

import java.util.List;

import static com.cafeteria.exceptions.containers.IMessages.Issues;

public class CoffeeMachine implements IMachine<Coffee> {
    private final CoffeeGrainsValidator ruler;
    private final CoffeeMixer mixer;

    public CoffeeMachine() {
        this.ruler = new CoffeeGrainsValidator();
        this.mixer = new CoffeeMixer();
    }

    @Override
    public IContainer make(EContainerType type, EContainerSize size,
                           EMeasureContainer measure, Coffee grains,
                           List<IComplement> complement) throws IssueMachineException {

        // TODO: 8/5/2023

        if (!this.ruler.isApplicable(size, grains)) {
            throw new IssueMachineException(Issues.NOT_ENOUGH_GRAINS);
        }

        ContainerBuilder containerBuilder = ContainerBuilder.builder();


        // Set amount of coffee

        final ECoffeeMix coffeeMixer = ECoffeeMix.getMixerBySize(size);
        final float amountCoffee = this.mixer.mixGrains(coffeeMixer, grains);

        IContainer container = containerBuilder
                .setSize(size)
                .setMeasure(measure)
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
}
