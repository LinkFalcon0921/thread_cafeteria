package com.cafeteria.containers;

import com.cafeteria.complements.IComplement;
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
    protected Set<IComplement> complements;

    protected Container(final ESizeContainer size, final float amount) {
        this(size, amount, amount);
    }

    protected Container(final ESizeContainer size, final float amount, final float actualAmount) {
        this.amount = amount;
        this.actualAmount = actualAmount;
        this.SIZE = size;
    }

    @Override
    public boolean addComplement(IComplement c, final int amount) {
        return applyComplement(c, amount);
    }

    @Override
    public boolean removeComplement(IComplement c, final int amount) {
        return applyComplement(c, -amount);
    }

    @Override
    public String getSize() {
        return String.format("%.2f%s", this.amount, this.SIZE);
    }

    @Override
    public String toString() {
        return String.format("%s: %s",
                this.getClass().getSimpleName(), this.getSize());
    }

    private boolean applyComplement(IComplement c, int amount) {
        if (Objects.isNull(this.complements)) {
            this.complements = new HashSet<>();
        }

        boolean result = false;

        for (IComplement complement : this.complements) {
            if (complement.equals(c)) {

                complement.increaseAmount(amount);

                result = true;
                break;
            }
        }
        return result;
    }
}
