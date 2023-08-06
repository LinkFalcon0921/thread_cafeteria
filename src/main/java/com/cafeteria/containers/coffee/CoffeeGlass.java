package com.cafeteria.containers.coffee;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.Glass;

public class CoffeeGlass extends Glass {
    public CoffeeGlass(EContainerSize size, float maxAmount) {
        super(size, maxAmount);
    }

    public CoffeeGlass(EContainerSize size, float maxAmount, float actualAmount) {
        super(size, maxAmount, actualAmount);
    }
}
