package com.cafeteria.containers.sizes.coffee;

import com.cafeteria.containers.EContainerSize;
import lombok.Getter;
import lombok.NonNull;

@Getter
public enum ECoffeeCupSize implements IContainerSize{
    SMALL(7f, 5),
    MEDIUM(12f, 10),
    BIG(16f, 16);

    final float maxContent;
    final int requiredGrains;

    ECoffeeCupSize(float oz, int requiredGrains) {
        this.maxContent = oz;
        this.requiredGrains = requiredGrains;
    }

    public static ECoffeeCupSize getBySize(@NonNull EContainerSize s){
        return ECoffeeCupSize.valueOf(s.name());
    }
}
