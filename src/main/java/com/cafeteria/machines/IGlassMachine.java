package com.cafeteria.machines;

import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.Glass;
import com.cafeteria.exceptions.containers.IssueMachineException;

import java.util.List;

public interface IGlassMachine<G extends Glass> extends IMachine{
    G prepareGlass(EContainerSize containerSize,
                   final List<IComplement> complement) throws IssueMachineException;
}
