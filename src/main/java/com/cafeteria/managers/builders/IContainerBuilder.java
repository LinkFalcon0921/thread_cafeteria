package com.cafeteria.managers.builders;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.IContainer;
import com.cafeteria.containers.IContainerSize;

public interface IContainerBuilder<C extends IContainer<CSIZE>, CSIZE extends IContainerSize> {

    IContainerBuilder<C, CSIZE> setSize(EContainerSize size);

    IContainerBuilder<C, CSIZE> setActualAmount(float actualAmount);

    IContainerBuilder<C, CSIZE> setMaxAmount(float maxAmount);
    C prepare();
}
