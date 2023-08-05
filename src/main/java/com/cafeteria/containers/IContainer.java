package com.cafeteria.containers;

import com.cafeteria.complements.IComplement;

public interface IContainer {
    String getSize();

    float getAmount();

    boolean addComplement(IComplement c, final int amount);
    boolean removeComplement(IComplement c, int amount);
}
