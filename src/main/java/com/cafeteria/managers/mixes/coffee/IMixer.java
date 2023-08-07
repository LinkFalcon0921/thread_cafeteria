package com.cafeteria.managers.mixes.coffee;

import com.cafeteria.grains.IGrain;

import java.util.Optional;

public interface IMixer<E extends Enum<E>, G extends IGrain> {
    float mixGrains(E e, Optional<G> g);
}
