package com.cafeteria.managers.mixes.tea;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.managers.mixes.IGrainMixDetails;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ETeaMix implements IGrainMixDetails {
    SMALL(1.3f),
    MEDIUM(1.9f),
    BIG(2.2f);

    final float mixVal;

    @NonNull
    public static ETeaMix getBySize(EContainerSize size) throws IllegalArgumentException {
        return ETeaMix.valueOf(size.name());
    }
}
