package com.cafeteria.containers.sizes.coffee;

import com.cafeteria.containers.EContainerSize;
import lombok.NonNull;

public enum ECoffeeCupSize {
    SMALL(7f),
    MEDIUM(12f),
    BIG(16f);

    final float oz;

    ECoffeeCupSize(float oz) {
        this.oz = oz;
    }

    public static ECoffeeCupSize getBySize(@NonNull EContainerSize s){
        return ECoffeeCupSize.valueOf(s.name());
    }
}
