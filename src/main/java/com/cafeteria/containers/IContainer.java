package com.cafeteria.containers;

import com.cafeteria.complements.IComplement;
import com.cafeteria.grains.IGrains;

public interface IContainer {
    float getActualAmount();

    IGrains getContent();

    boolean setContent(IGrains g);

    EContainerSize getSize();

    boolean addComplement(IComplement c);

    boolean removeComplement(IComplement c);
}
