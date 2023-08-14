package com.cafeteria.managers.factories.getters.mixers.tea;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.managers.factories.getters.mixers.IMixerGetter;
import com.cafeteria.managers.mixes.tea.ETeaMix;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TeaMixerGetter implements IMixerGetter<ETeaMix> {

    @Override
    public ETeaMix getMixerOf(EContainerSize size) {
        return ETeaMix.getBySize(size);
    }
}
