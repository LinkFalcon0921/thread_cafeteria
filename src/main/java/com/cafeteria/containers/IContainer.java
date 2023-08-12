package com.cafeteria.containers;

import com.cafeteria.complements.IComplement;
import com.cafeteria.grains.IGrain;

public interface IContainer<CSIZE extends IContainerSize> {
    float getActualAmount();
    void setActualAmount(float amount);

    void fill(float amount);

    CSIZE getSize();

    IGrain getGrains();

    boolean setGrains(IGrain g);

    boolean addComplement(IComplement c);

    boolean removeComplement(IComplement c);
}
