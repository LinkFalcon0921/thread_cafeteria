package com.cafeteria.managers.builders.coffee;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.coffee.CoffeeGlass;
import com.cafeteria.containers.sizes.coffee.ECoffeeGlassSize;
import com.cafeteria.managers.builders.ContainerBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CoffeeGlassContainerBuilder extends ContainerBuilder<CoffeeGlass, ECoffeeGlassSize> {
    @NonNull
    public static CoffeeGlassContainerBuilder builder() {
        return new CoffeeGlassContainerBuilder();
    }

    public CoffeeGlass prepare() {
        return new CoffeeGlass(this.size, this.actualAmount, this.maxAmount);
    }
}
