package com.cafeteria.complements;

import com.cafeteria.fields.IStackable;
import com.cafeteria.fields.IType;

public interface IComplement extends IStackable<IComplement, Float>, IType<EComplementType> {
    float getAmount();
}
