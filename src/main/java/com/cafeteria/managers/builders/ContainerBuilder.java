package com.cafeteria.managers.builders;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.IContainer;
import com.cafeteria.containers.IContainerSize;
import com.cafeteria.managers.builders.coffee.CoffeeCupContainerBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class ContainerBuilder<C extends IContainer<CSIZE>, CSIZE extends IContainerSize>
        implements IContainerBuilder<C, CSIZE> {

    protected EContainerSize size;
    protected float actualAmount;
    protected float maxAmount;

    public ContainerBuilder setSize(EContainerSize size) {
        this.size = size;
        return this;
    }

    public ContainerBuilder setActualAmount(float actualAmount) {
        this.actualAmount = actualAmount;
        return this;

    }

    public ContainerBuilder setMaxAmount(float maxAmount) {
        this.maxAmount = maxAmount;
        return this;
    }

}
