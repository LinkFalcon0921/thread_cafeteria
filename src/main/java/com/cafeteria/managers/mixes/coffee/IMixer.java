package com.cafeteria.managers.mixes.coffee;

import com.cafeteria.grains.IGrain;
import com.cafeteria.managers.mixes.IGrainMixDetails;

import java.util.Optional;

public interface IMixer<E_MIX extends IGrainMixDetails, G extends IGrain> {
    float mixGrains(E_MIX e, Optional<G> gOptional);
}
