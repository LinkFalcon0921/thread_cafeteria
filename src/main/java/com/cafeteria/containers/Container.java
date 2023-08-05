package com.cafeteria.containers;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public abstract class Container implements IContainer{
    protected final float amount;
    protected float actualAmount;
    protected final ESizeContainer SIZE;

    protected Container(final ESizeContainer size, final float amount) {
        this(size, amount, amount);
    }

    protected Container(final ESizeContainer size, final float amount, final float actualAmount) {
        this.amount = amount;
        this.actualAmount = actualAmount;
        this.SIZE = size;
    }

    @Override
    public String getSize() {
        return String.format("%.2f%s", this.amount, this.SIZE);
    }
}
