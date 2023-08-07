package com.cafeteria.managers.mixes.coffee;

import com.cafeteria.grains.IGrain;

public interface IMixer<E extends Enum<E>, G extends IGrain> {
    float mixGrains(E e, G g);
}
