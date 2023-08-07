package com.cafeteria.managers.builders.coffee;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.IContainer;

public interface IContainerBuilder<C extends IContainer<ES>, ES extends Enum<ES>> {

    IContainerBuilder<C,ES> setSize(EContainerSize size);

    IContainerBuilder<C,ES> setActualAmount(float actualAmount);

    IContainerBuilder<C,ES> setMaxAmount(float maxAmount);
    C prepare();
}
