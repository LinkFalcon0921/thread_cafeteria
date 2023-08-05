package com.cafeteria.containers;

import com.cafeteria.complements.IComplement;
import com.cafeteria.grains.IGrains;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
public abstract class Container implements IContainer {
    protected final float amount;
    protected float actualAmount;
    protected final ESizeContainer SIZE;

    @Setter(AccessLevel.NONE)
    protected IGrains content;
    @Setter(AccessLevel.NONE)
    protected Set<IComplement> complements;

    protected Container(final ESizeContainer size, final float amount) {
        this(size, amount, amount);
    }

    protected Container(final ESizeContainer size, final float amount, final float actualAmount) {
        this.amount = amount;
        this.actualAmount = actualAmount;
        this.SIZE = size;
    }

    public boolean setContent(IGrains content) {
        if (Objects.nonNull(this.content)) {
            return false;
        }

        this.content = content;

        return true;
    }

    @Override
    public boolean addComplement(IComplement c) {
        setComplement();
        return this.complements.add(c);
    }

    @Override
    public boolean removeComplement(IComplement c) {
        setComplement();
        return this.complements.remove(c);
    }

    @Override
    public String getSize() {
        return String.format("%.2f %s", this.amount, this.SIZE);
    }

    @Override
    public String toString() {
        return String.format("%s: %s",
                this.getClass().getSimpleName(), this.getSize());
    }

    private void setComplement() {
        if (Objects.isNull(this.complements)) {
            this.complements = new HashSet<>();
        }
    }
}
