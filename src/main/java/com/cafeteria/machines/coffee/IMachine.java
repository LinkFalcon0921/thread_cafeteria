package com.cafeteria.machines.coffee;

import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.EMeasureContainer;
import com.cafeteria.containers.IContainer;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.grains.IGrains;

import java.util.List;

/** @param <G> Grains Enum*/
public interface IMachine<G extends IGrains> {
    IContainer make(EContainerType type, EContainerSize containerSize,
                    final G grains, final List<IComplement> complement) throws IssueMachineException;
}
