package com.cafeteria.machines.coffee;

import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.IContainer;
import com.cafeteria.grains.coffee.Coffee;
import com.cafeteria.managers.ruler.coffee.CoffeeRuler;

import java.util.List;

public class CoffeeMachine implements IMachine<Coffee> {
    private final CoffeeRuler ruler;

    public CoffeeMachine() {
        this.ruler = new CoffeeRuler();
    }

    @Override
    public IContainer make(Coffee grains, IContainer container, List<IComplement> complement) {

        // TODO: 8/5/2023

        if (!this.ruler.isApplicable(container.getSize(), grains)) {
            return container;
        }

        if (container.setContent(grains)) {
            return container;
        }

        for (IComplement c : complement) {
            container.addComplement(c);
        }

        return container;
    }
}
