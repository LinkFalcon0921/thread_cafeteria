package com.cafeteria.containers;

import com.cafeteria.complements.IComplement;
import com.cafeteria.grains.IGrain;
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
public abstract class Container<ES extends Enum<ES>> implements IContainer<ES> {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    protected final EContainerSize SIZE;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    protected final EMeasureContainer MEASURE_SIZE;

    protected float actualAmount;

    @Setter(AccessLevel.NONE)
    protected final float maxAmount;

    @Setter(AccessLevel.NONE)
    protected IGrain grains;

    @Setter(AccessLevel.NONE)
    protected Set<IComplement> complements;

    protected Container(final EContainerSize size, final float maxAmount) {
        this(size, maxAmount, 0f);
    }

    protected Container(final EContainerSize size, final float maxAmount, final float actualAmount) {
        this.MEASURE_SIZE = EMeasureContainer.OZ;
        this.SIZE = size;
        this.maxAmount = maxAmount;
        this.actualAmount = actualAmount;
    }

    public boolean setGrains(IGrain content) {
        if (Objects.nonNull(this.grains)) {
            return false;
        }

        this.grains = content;

        return true;
    }

    @Override
    public void fill(float amount) {

        // If the amount is higher than the max content
        // If the actual amount is equals than the max content
        // then do nothing
        if (Float.compare(this.actualAmount, amount) > 0
                && Float.compare(this.actualAmount, this.maxAmount) == 0) {
            return;
        }

        // Fill the container
        this.actualAmount = this.actualAmount + Math.abs(this.maxAmount - amount);
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
