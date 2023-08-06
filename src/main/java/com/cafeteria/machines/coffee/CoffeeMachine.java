package com.cafeteria.machines.coffee;

import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.EMeasureContainer;
import com.cafeteria.containers.IContainer;
import com.cafeteria.exceptions.containers.IMessages;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.grains.coffee.Coffee;
import com.cafeteria.managers.containers.ContainerBuilder;
import com.cafeteria.managers.mixes.coffee.CoffeeMixer;
import com.cafeteria.managers.mixes.coffee.ECoffeeMix;
import com.cafeteria.managers.ruler.coffee.CoffeeRuler;

import java.util.List;

import static com.cafeteria.exceptions.containers.IMessages.*;

public class CoffeeMachine implements IMachine<ECoffeeMix, Coffee> {
    private final CoffeeRuler ruler;
    private final CoffeeMixer mixer;

    public CoffeeMachine() {
        this.ruler = new CoffeeRuler();
        mixer = new CoffeeMixer();
    }

    @Override
    public IContainer make(EContainerType type, EContainerSize size, EMeasureContainer measure, Coffee grains, List<IComplement> complement)
            throws IssueMachineException {

        // TODO: 8/5/2023

        if (!this.ruler.isApplicable(size, grains)) {
            throw new IssueMachineException(Issues.NOT_ENOUGH_GRAINS);
        }

        IContainer container = ContainerBuilder.builder()
                .setSize(size)
                .setMeasure(measure)
                .setMaxAmount()
                .build(type);

        if (!container.setGrains(grains)) {
            return container;
        }

        // Set amount of coffee
        final float amountCoffee = this.mixer.mixGrains(ECoffeeMix.BIG, grains);
        container.setActualAmount(amountCoffee);

        // Add complements
        for (IComplement c : complement) {
            container.addComplement(c);
        }

        return container;
    }
}
