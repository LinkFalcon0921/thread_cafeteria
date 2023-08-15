package com.cafeteria.managers.builders;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.IContainer;
import com.cafeteria.containers.IContainerSize;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class ContainerBuilder<C extends IContainer<CSIZE>, CSIZE extends IContainerSize>
        implements IContainerBuilder<C, CSIZE> {

    protected EContainerSize size;
    protected float actualAmount;
    protected float maxAmount;

    public ContainerBuilder<C, CSIZE> setSize(EContainerSize size) {
        this.size = size;
        return this;
    }

    public ContainerBuilder<C, CSIZE> setActualAmount(float actualAmount) {
        this.actualAmount = actualAmount;
        return this;

    }

    public ContainerBuilder<C, CSIZE> setMaxAmount(float maxAmount) {
        this.maxAmount = maxAmount;
        return this;
    }

}
