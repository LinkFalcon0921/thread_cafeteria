package com.cafeteria.containers.coffee;

import com.cafeteria.containers.Cup;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.sizes.coffee.ECoffeeCupSize;

public class CoffeeCup extends Cup<ECoffeeCupSize> {
    public CoffeeCup(EContainerSize size, float maxAmount) {
        super(size, maxAmount);
    }

    public CoffeeCup(EContainerSize size, float maxAmount, float actualAmount) {
        super(size, maxAmount, actualAmount);
    }

    @Override
    public ECoffeeCupSize getSize() {
        return ECoffeeCupSize.getBySize(this.SIZE);
    }
}
