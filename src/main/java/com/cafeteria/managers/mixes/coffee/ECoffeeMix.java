package com.cafeteria.managers.mixes.coffee;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.managers.mixes.IGrainMixDetails;
import lombok.Getter;
import lombok.NonNull;

@Getter
public enum ECoffeeMix implements IGrainMixDetails {
    SMALL(1.3f),
    MEDIUM(1.9f),
    BIG(2.2f);

    final float mixVal;

    ECoffeeMix(float value) {
        this.mixVal = value;
    }

    @NonNull
    public static ECoffeeMix getBySize(EContainerSize size) throws IllegalArgumentException {
        return ECoffeeMix.valueOf(size.name());
    }

}
