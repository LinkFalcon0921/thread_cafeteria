package com.cafeteria.managers.factories.grains;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.sizes.coffee.IContainerSize;
import org.jetbrains.annotations.NotNull;

public interface IGrainContainerGetterManager {
    IContainerSize getGrainContainerDetails(@NotNull EContainerType containerType, @NotNull EContainerSize containerSize);
}
