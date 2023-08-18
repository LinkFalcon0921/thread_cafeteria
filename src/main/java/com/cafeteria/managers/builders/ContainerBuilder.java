package com.cafeteria.managers.builders;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.IContainer;
import com.cafeteria.containers.IContainerSize;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class ContainerBuilder<C extends IContainer<C_SIZE>, C_SIZE extends IContainerSize>
        implements IContainerBuilder<C, C_SIZE> {

    protected EContainerSize size;
    protected float actualAmount;
    protected float maxAmount;

    public ContainerBuilder<C, C_SIZE> setSize(EContainerSize size) {
        this.size = size;
        return this;
    }

    public ContainerBuilder<C, C_SIZE> setActualAmount(float actualAmount) {
        this.actualAmount = actualAmount;
        return this;

    }

    public ContainerBuilder<C, C_SIZE> setMaxAmount(float maxAmount) {
        this.maxAmount = maxAmount;
        return this;
    }

}
