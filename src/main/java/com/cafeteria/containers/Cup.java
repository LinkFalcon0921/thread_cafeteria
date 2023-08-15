package com.cafeteria.containers;

import com.cafeteria.containers.sizes.coffee.ECoffeeCupSize;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Cup<ES extends IContainerSize> extends Container<ES> {

    public Cup(EContainerSize size, float maxAmount) {
        super(size, maxAmount);
    }

    public Cup(EContainerSize size, float maxAmount, float actualAmount) {
        super(size, maxAmount, actualAmount);
    }

}
