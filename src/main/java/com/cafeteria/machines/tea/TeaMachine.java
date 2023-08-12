package com.cafeteria.machines.tea;

import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.tea.TeaCup;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.grains.EGrainsType;
import com.cafeteria.machines.Machine;

import java.util.List;

public class TeaMachine extends Machine implements ITeaCupMachine {
    public TeaMachine() {
//        super(EGrainsType.TEA, /mixer, containerGetterFactory);
    }

    @Override
    public TeaCup prepareCup(EContainerSize containerSize, List<IComplement> complement)
            throws IssueMachineException {
        return null;
    }
}
