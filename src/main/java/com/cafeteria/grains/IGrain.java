package com.cafeteria.grains;

import com.cafeteria.fields.IStackable;
import com.cafeteria.fields.IType;

public interface IGrain extends IStackable<IGrain ,Integer>, IType<EGrainsType> {
    int getAmount();
}
