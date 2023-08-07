package com.cafeteria.managers.factories;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.sizes.coffee.ECoffeeGlassSize;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GlassContainerGetter implements IContainerGetter<ECoffeeGlassSize> {
    @Override
    public ECoffeeGlassSize getDetailsOf(EContainerSize containerSize) {
        return ECoffeeGlassSize.getBySize(containerSize);
    }
}
