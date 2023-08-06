package com.cafeteria.managers.containers;

import com.cafeteria.containers.*;
import lombok.Setter;

@Setter
public class ContainerBuilder {

    private EContainerSize size;
    private float actualAmount;
    private float maxAmount;

    public static ContainerBuilder builder() {
        return new ContainerBuilder();
    }

    public IContainer build(EContainerType containerType) {
        return switch (containerType) {
            case GLASS -> new Glass(this.size, this.maxAmount, this.actualAmount);
            default -> new Cup(this.size, this.maxAmount, this.actualAmount);
        };
    }

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
