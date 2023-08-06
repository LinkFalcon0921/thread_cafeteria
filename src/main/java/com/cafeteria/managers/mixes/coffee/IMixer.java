package com.cafeteria.managers.mixes.coffee;

import com.cafeteria.grains.IGrains;

public interface IMixer<E extends Enum<E>, G extends IGrains> {
    float mixGrains(E e, G g);
}
