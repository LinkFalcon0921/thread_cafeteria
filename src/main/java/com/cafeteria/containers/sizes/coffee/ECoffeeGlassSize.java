package com.cafeteria.containers.sizes.coffee;

import com.cafeteria.containers.EContainerSize;
import lombok.NonNull;

public enum ECoffeeGlassSize {
    SMALL(13f),
    MEDIUM(16f),
    BIG(20f);

    final float oz;

    ECoffeeGlassSize(float oz) {
        this.oz = oz;
    }

    public static ECoffeeGlassSize getBySize(@NonNull EContainerSize s){
        return ECoffeeGlassSize.valueOf(s.name());
    }
}
