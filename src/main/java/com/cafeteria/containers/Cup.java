package com.cafeteria.containers;

import com.cafeteria.containers.sizes.coffee.ECoffeeCupSize;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cup extends Container<ECoffeeCupSize> {

    public Cup(EContainerSize size, float maxAmount) {
        super(size, maxAmount);
    }

    public Cup(EContainerSize size, float maxAmount, float actualAmount) {
        super(size, maxAmount, actualAmount);
    }

    @Override
    public ECoffeeCupSize getSize() {
        return ECoffeeCupSize.getBySize(this.SIZE);
    }
}
