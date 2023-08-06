package com.cafeteria.machines.coffee;

import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.IContainer;
import com.cafeteria.grains.coffee.Coffee;
import com.cafeteria.managers.mixes.coffee.CoffeeMixer;
import com.cafeteria.managers.mixes.coffee.ECoffeeMixes;
import com.cafeteria.managers.ruler.coffee.CoffeeRuler;

import java.util.List;

public class CoffeeMachine implements IMachine<Coffee> {
    private final CoffeeRuler ruler;
    private final CoffeeMixer mixer;

    public CoffeeMachine() {
        this.ruler = new CoffeeRuler();
        mixer = new CoffeeMixer();
    }

    @Override
    public IContainer make(Coffee grains, IContainer container, List<IComplement> complement) {

        // TODO: 8/5/2023

        if (!this.ruler.isApplicable(container.getSize(), grains)) {
            return container;
        }

        if (!container.setGrains(grains)) {
            return container;
        }

        // Set amount of coffee
        final float amountCoffee = this.mixer.mixGrains(ECoffeeMixes.BIG, grains);
        container.setActualAmount(amountCoffee);

        // Add complements
        for (IComplement c : complement) {
            container.addComplement(c);
        }

        return container;
    }
}
