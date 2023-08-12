package com.cafeteria.managers.factories.getters.mixers;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.managers.mixes.IGrainMixDetails;

public interface IMixerGetter<MIX extends IGrainMixDetails> {
    MIX getMixerOf(EContainerSize size);
}
