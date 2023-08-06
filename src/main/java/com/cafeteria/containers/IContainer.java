package com.cafeteria.containers;

import com.cafeteria.complements.IComplement;
import com.cafeteria.grains.IGrains;

public interface IContainer {
    float getActualAmount();
    void setActualAmount(float amount);

    void fill(float amount);

    IGrains getGrains();

    boolean setGrains(IGrains g);

    EContainerSize getSize();

    boolean addComplement(IComplement c);

    boolean removeComplement(IComplement c);
}
