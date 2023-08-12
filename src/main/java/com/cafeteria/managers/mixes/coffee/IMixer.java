package com.cafeteria.managers.mixes.coffee;

import com.cafeteria.grains.IGrain;

import java.util.Optional;

public interface IMixer<E_MIX extends Enum<E_MIX>, G extends IGrain> {
    float mixGrains(E_MIX e, Optional<G> gOptional);
}
