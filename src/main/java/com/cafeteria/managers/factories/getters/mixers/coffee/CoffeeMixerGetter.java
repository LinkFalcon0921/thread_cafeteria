package com.cafeteria.managers.factories.getters.mixers.coffee;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.managers.factories.getters.mixers.IMixerGetter;
import com.cafeteria.managers.mixes.coffee.ECoffeeMix;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CoffeeMixerGetter implements IMixerGetter<ECoffeeMix> {

    @Override
    public ECoffeeMix getMixerOf(EContainerSize size) {
        return ECoffeeMix.getBySize(size);
    }
}
