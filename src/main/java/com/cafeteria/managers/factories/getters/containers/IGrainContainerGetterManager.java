package com.cafeteria.managers.factories.getters.containers;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.IContainerSize;
import com.cafeteria.exceptions.containers.IssueMachineException;
import org.jetbrains.annotations.NotNull;

public interface IGrainContainerGetterManager {
    IContainerSize getGrainContainerDetails(@NotNull EContainerType containerType,
                                            @NotNull EContainerSize containerSize)
            throws IssueMachineException;
}
