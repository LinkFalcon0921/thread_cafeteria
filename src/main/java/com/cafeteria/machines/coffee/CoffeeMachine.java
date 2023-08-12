package com.cafeteria.machines.coffee;

import com.cafeteria.actioners.Caster;
import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.coffee.CoffeeCup;
import com.cafeteria.containers.coffee.CoffeeGlass;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.IGrain;
import com.cafeteria.grains.coffee.Coffee;
import com.cafeteria.machines.Machine;
import com.cafeteria.managers.builders.coffee.CoffeeCupContainerBuilder;
import com.cafeteria.managers.builders.coffee.CoffeeGlassContainerBuilder;
import com.cafeteria.managers.factories.getters.containers.coffee.CoffeeContainerGetterManager;
import com.cafeteria.managers.factories.getters.mixers.coffee.CoffeeMixerGetter;
import com.cafeteria.managers.mixes.coffee.CoffeeMixer;
import com.cafeteria.managers.mixes.coffee.ECoffeeMix;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Function;

public class CoffeeMachine
        extends Machine
                <CoffeeMixer,
                ECoffeeMix,
                Coffee>
        implements ICoffeeCupMachine, ICoffeeGlassMachine {

    public CoffeeMachine() {
        super(EGrainsType.COFFEE, new CoffeeMixerGetter(),
                new CoffeeMixer(), new CoffeeContainerGetterManager());
    }

    @Override
    public CoffeeCup prepareCup(EContainerSize size, List<IComplement> complements) throws IssueMachineException {
        return prepareContainer(CoffeeCupContainerBuilder.builder(), EContainerType.CUP, size, complements);
    }

    @Override
    public CoffeeGlass prepareGlass(EContainerSize size, List<IComplement> complements) throws IssueMachineException {
        return prepareContainer(CoffeeGlassContainerBuilder.builder(), EContainerType.GLASS, size, complements);
    }

    @NotNull
    @Override
    protected Function<IGrain, Coffee> getMapper() {
        return Caster.getInstance().castTo(Coffee.class);
    }
}
