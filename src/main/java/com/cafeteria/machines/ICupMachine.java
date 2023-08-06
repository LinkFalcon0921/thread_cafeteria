package com.cafeteria.machines;

import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.IContainer;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.grains.IGrains;
import com.cafeteria.machines.coffee.IMachine;

import java.util.List;

public interface ICupMachine<G extends IGrains, ES extends Enum<ES>> extends IMachine<G, ES> {
    IContainer<ES> makeCup(EContainerSize containerSize, final G grains,
                        final List<IComplement> complement) throws IssueMachineException;

}
