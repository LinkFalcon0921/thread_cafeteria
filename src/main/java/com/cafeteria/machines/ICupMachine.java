package com.cafeteria.machines;

import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.Cup;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.IContainer;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.grains.IGrain;

import java.util.List;

public interface ICupMachine<C extends Cup> extends IMachine{
    C prepareCup(EContainerSize containerSize, final List<IComplement> complement) throws IssueMachineException;
}
