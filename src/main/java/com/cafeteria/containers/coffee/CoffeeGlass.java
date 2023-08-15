package com.cafeteria.containers.coffee;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.Glass;
import com.cafeteria.containers.sizes.coffee.ECoffeeGlassSize;

public class CoffeeGlass extends Glass<ECoffeeGlassSize> {
    public CoffeeGlass(EContainerSize size, float maxAmount) {
        super(size, maxAmount);
    }

    public CoffeeGlass(EContainerSize size, float maxAmount, float actualAmount) {
        super(size, maxAmount, actualAmount);
    }

    @Override
    public ECoffeeGlassSize getSize() {
        return ECoffeeGlassSize.getBySize(this.SIZE);
    }
}
