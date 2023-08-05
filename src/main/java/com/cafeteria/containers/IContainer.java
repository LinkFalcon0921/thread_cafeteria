package com.cafeteria.containers;

import com.cafeteria.complements.IComplement;
import com.cafeteria.grains.IGrains;

public interface IContainer {
    String getSize();

    IGrains getContent();

    boolean setContent(IGrains g);

    float getAmount();

    boolean addComplement(IComplement c);

    boolean removeComplement(IComplement c);
}
