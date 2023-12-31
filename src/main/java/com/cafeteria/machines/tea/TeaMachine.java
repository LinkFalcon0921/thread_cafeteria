package com.cafeteria.machines.tea;

import com.cafeteria.actioners.Caster;
import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.tea.TeaCup;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.IGrain;
import com.cafeteria.grains.tea.Tea;
import com.cafeteria.machines.Machine;
import com.cafeteria.managers.builders.tea.TeaCupContainerBuilder;
import com.cafeteria.managers.factories.getters.containers.tea.TeaContainerGetterManager;
import com.cafeteria.managers.factories.getters.mixers.tea.TeaMixerGetter;
import com.cafeteria.managers.mixes.tea.ETeaMix;
import com.cafeteria.managers.mixes.tea.TeaMixer;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Function;

public class TeaMachine
        extends Machine
                <TeaMixer,
                ETeaMix,
                Tea>
        implements ITeaCupMachine {
    public TeaMachine() {
        super(EGrainsType.TEA, new TeaMixerGetter(),
                new TeaMixer(), new TeaContainerGetterManager());
    }

    @Override
    public TeaCup prepareCup(EContainerSize size, List<IComplement> complement)
            throws IssueMachineException {
        return super.prepareContainer(TeaCupContainerBuilder.builder(), EContainerType.CUP, size, complement);
    }

    @NotNull
    @Override
    protected Function<IGrain, Tea> getMapper() {
        return Caster.getInstance().castTo(Tea.class);
    }
}
