package com.cafeteria.managers.mixes.coffee;

import com.cafeteria.containers.EContainerSize;

public enum ECoffeeMix {
    SMALL(1.3f),
    MEDIUM(1.9f),
    BIG(2.2f);

    final float MIX_VAL;

    ECoffeeMix(float value) {
        this.MIX_VAL = value;
    }

    public ECoffeeMix getMixerBySize(EContainerSize size) throws IllegalArgumentException{
        return ECoffeeMix.valueOf(size.name());
    }
}
