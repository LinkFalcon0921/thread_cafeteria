package com.cafeteria.fields;

import com.cafeteria.grains.EGrainsType;

public interface IType<E extends Enum<E>> {
    E getType();
    boolean isTypeOf(E type);
}
