package com.cafeteria.machines.Coffee;

import com.cafeteria.grains.EGrainsType;

public interface IMachine<E extends Enum<EGrainsType>> {
    void make();

    boolean add(E e);
}
