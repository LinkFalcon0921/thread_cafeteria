package com.cafeteria.managers.builders.coffee;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.coffee.CoffeeCup;
import com.cafeteria.containers.coffee.CoffeeGlass;
import com.cafeteria.containers.sizes.coffee.ECoffeeGlassSize;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CoffeeGlassContainerBuilder implements IContainerBuilder<CoffeeGlass, ECoffeeGlassSize> {
    private EContainerSize size;
    private float actualAmount;
    private float maxAmount;

    @NonNull
    public static CoffeeGlassContainerBuilder builder() {
        return new CoffeeGlassContainerBuilder();
    }

    public CoffeeGlass prepare() {
        return new CoffeeGlass(this.size, this.actualAmount, this.maxAmount);
    }

    public CoffeeGlassContainerBuilder setSize(EContainerSize size) {
        this.size = size;
        return this;
    }

    public CoffeeGlassContainerBuilder setActualAmount(float actualAmount) {
        this.actualAmount = actualAmount;
        return this;

    }

    public CoffeeGlassContainerBuilder setMaxAmount(float maxAmount) {
        this.maxAmount = maxAmount;
        return this;

    }
}
