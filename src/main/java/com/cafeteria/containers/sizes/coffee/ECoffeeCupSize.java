package com.cafeteria.containers.sizes.coffee;

import com.cafeteria.containers.EContainerSize;
import lombok.NonNull;

public enum ECoffeeCupSize {
    SMALL(7f, 5),
    MEDIUM(12f, 10),
    BIG(16f, 16);

    final float oz;
    final int requiredGrains;

    ECoffeeCupSize(float oz, int requiredGrains) {
        this.oz = oz;
        this.requiredGrains = requiredGrains;
    }

    public static ECoffeeCupSize getBySize(@NonNull EContainerSize s){
        return ECoffeeCupSize.valueOf(s.name());
    }
}
