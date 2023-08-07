package com.cafeteria.complements;

import com.cafeteria.fields.IStackable;

public interface IComplement extends IStackable<IComplement, Float> {
    float getAmount();

    boolean isTypeOf(EComplementType type);

    EComplementType getType();
}
