package com.cafeteria.managers.mixes.coffee;

import com.cafeteria.containers.EContainerSize;

import java.util.function.Function;

public enum ECoffeeMix implements Function<EContainerSize, ECoffeeMix> {
    SMALL(1.3f),
    MEDIUM(1.9f),
    BIG(2.2f);

    final float MIX_VAL;

    ECoffeeMix(float value) {
        this.MIX_VAL = value;
    }

    public static ECoffeeMix getBySize(EContainerSize size) throws IllegalArgumentException{
        return ECoffeeMix.valueOf(size.name());
    }

    /**
     * Applies this function to the given argument.
     *
     * @param containerSize the function argument
     * @return the function result
     */
    @Override
    public ECoffeeMix apply(EContainerSize containerSize) {
        return getBySize(containerSize);
    }
}
