package com.cafeteria.machines.coffee;

import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.coffee.CoffeeCup;
import com.cafeteria.containers.coffee.CoffeeGlass;
import com.cafeteria.containers.sizes.coffee.ECoffeeCupSize;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.coffee.Coffee;
import com.cafeteria.machines.Machine;
import com.cafeteria.managers.builders.coffee.CoffeeCupContainerBuilder;
import com.cafeteria.managers.builders.coffee.CoffeeGlassContainerBuilder;
import com.cafeteria.managers.factories.CoffeeCupContainerGetter;
import com.cafeteria.managers.factories.CoffeeGlassContainerGetter;
import com.cafeteria.managers.mixes.coffee.CoffeeMixer;
import com.cafeteria.managers.mixes.coffee.ECoffeeMix;

import java.util.List;
import java.util.Map;

public class CoffeeMachine
        extends Machine<ECoffeeCupSize,
        CoffeeMixer,
        ECoffeeMix,
        Coffee>
        implements ICoffeeCupMachine, ICoffeeGlassMachine {

    public CoffeeMachine() {
        var containerGetterMap = Map
                .of(EContainerType.CUP, new CoffeeCupContainerGetter(),
                        EContainerType.GLASS, new CoffeeGlassContainerGetter());

        super(EGrainsType.COFFEE, new CoffeeMixer(), containerGetterMap);
    }

    @Override
    public CoffeeCup prepareCup(EContainerSize size, List<IComplement> complements) throws IssueMachineException {
        return prepareContainer(CoffeeCupContainerBuilder.builder(), EContainerType.CUP, size,
                complements, Coffee.class, ECoffeeMix.getBySize(size), complements);
    }

    @Override
    public CoffeeGlass prepareGlass(EContainerSize size, List<IComplement> complements) throws IssueMachineException {
        return prepareContainer(CoffeeGlassContainerBuilder.builder(), EContainerType.GLASS, size, complements);
    }

}
