package com.cafeteria.machines.coffee;

import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.IContainer;
import com.cafeteria.grains.coffee.Coffee;

import java.util.List;

public class CoffeeMachine implements IMachine<Coffee> {
    @Override
    public IContainer make(Coffee grains, IContainer container, List<IComplement> complement) {
        // TODO: 8/5/2023
        container.setContent(grains);

        for (IComplement c : complement) {
            container.addComplement(c);
        }

        return container;
    }
}
