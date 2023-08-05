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
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    protected final EContainerSize SIZE;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    protected final EMeasureContainer MEASURE_SIZE;
    protected float actualAmount;

    @Setter(AccessLevel.NONE)
    protected IGrains content;
    @Setter(AccessLevel.NONE)
    protected Set<IComplement> complements;

    protected Container(final EMeasureContainer measure, final EContainerSize size, final float actualAmount) {
        this.MEASURE_SIZE = measure;
        this.SIZE = size;
        this.actualAmount = actualAmount;
    }

    @Override
    public EContainerSize getSize() {
        return this.SIZE;
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
