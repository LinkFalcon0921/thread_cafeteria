package com.cafeteria.containers.sizes.coffee;

import com.cafeteria.containers.EContainerSize;
import lombok.Getter;
import lombok.NonNull;

@Getter
public enum ECoffeeGlassSize implements IContainerSize {
    SMALL(13f, 15),
    MEDIUM(16f, 20),
    BIG(20f, 24);

    private final float maxContent;
    private final int requiredGrainCount;

    ECoffeeGlassSize(float maxContent, int requiredGrains) {
        this.maxContent = maxContent;
        this.requiredGrainCount = requiredGrains;
    }

    public static ECoffeeGlassSize getBySize(@NonNull EContainerSize s) {
        return ECoffeeGlassSize.valueOf(s.name());
    }


}
