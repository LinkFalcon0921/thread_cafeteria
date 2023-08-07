package com.cafeteria.grains;

import com.cafeteria.fields.IStackable;

public interface IGrain extends IStackable<IGrain ,Integer> {
    EGrainsType getType();
    int getAmount();
    boolean isTypeOf(EGrainsType type);
}
