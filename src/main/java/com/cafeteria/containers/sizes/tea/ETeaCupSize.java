package com.cafeteria.containers.sizes.tea;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.IContainerSize;
import lombok.Getter;
import lombok.NonNull;

@Getter
public enum ETeaCupSize implements IContainerSize {
    SMALL(7f, 15),
    MEDIUM(12f, 26),
    BIG(16f, 35);

    private final float maxContent;
    private final int requiredGrainCount;

    ETeaCupSize(float oz, int requiredGrains) {
        this.maxContent = oz;
        this.requiredGrainCount = requiredGrains;
    }

    public static ETeaCupSize getBySize(@NonNull EContainerSize s) {
        return ETeaCupSize.valueOf(s.name());
    }
}
