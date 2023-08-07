package com.cafeteria.containers;

import com.cafeteria.complements.IComplement;
import com.cafeteria.grains.IGrain;

public interface IContainer<ES extends Enum<ES>> {
    float getActualAmount();
    void setActualAmount(float amount);

    void fill(float amount);

    IGrain getGrains();

    boolean setGrains(IGrain g);

    ES getSize();

    boolean addComplement(IComplement c);

    boolean removeComplement(IComplement c);
}
