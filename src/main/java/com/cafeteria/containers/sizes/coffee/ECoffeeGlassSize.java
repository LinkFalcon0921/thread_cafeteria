package com.cafeteria.containers.sizes.coffee;

import com.cafeteria.containers.EContainerSize;
import lombok.NonNull;

public enum ECoffeeGlassSize {
    SMALL(13f, 15),
    MEDIUM(16f, 20),
    BIG(20f, 24);

    final float oz;
    final int requiredGrains;


    ECoffeeGlassSize(float oz, int requiredGrains) {
        this.oz = oz;
        this.requiredGrains = requiredGrains;
    }

    public static ECoffeeGlassSize getBySize(@NonNull EContainerSize s) {
        return ECoffeeGlassSize.valueOf(s.name());
    }
}
