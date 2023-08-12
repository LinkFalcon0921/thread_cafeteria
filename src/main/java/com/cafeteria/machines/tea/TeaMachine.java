package com.cafeteria.machines.tea;

import com.cafeteria.actioners.Caster;
import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.tea.TeaCup;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.tea.Tea;
import com.cafeteria.machines.Machine;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Function;

public class TeaMachine extends Machine implements ITeaCupMachine {
    public TeaMachine() {
        // TODO: 8/12/2023  replace each null
        super(EGrainsType.TEA, null, null, null);
    }

    @Override
    public TeaCup prepareCup(EContainerSize containerSize, List<IComplement> complement)
            throws IssueMachineException {
        return null;
    }

    @NotNull
    @Override
    protected Function getMapper() {
        return Caster.getInstance().castTo(Tea.class);
    }
}
