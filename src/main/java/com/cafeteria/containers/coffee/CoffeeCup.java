package com.cafeteria.containers.coffee;

import com.cafeteria.containers.Cup;
import com.cafeteria.containers.EContainerSize;

public class CoffeeCup extends Cup {
    public CoffeeCup(EContainerSize size, float maxAmount) {
        super(size, maxAmount);
    }

    public CoffeeCup(EContainerSize size, float maxAmount, float actualAmount) {
        super(size, maxAmount, actualAmount);
    }
}
