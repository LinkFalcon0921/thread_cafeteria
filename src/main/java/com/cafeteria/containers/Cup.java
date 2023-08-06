package com.cafeteria.containers;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cup extends Container {

    public Cup(EContainerSize size, float maxAmount) {
        super(size, maxAmount);
    }

    public Cup(EContainerSize size, float maxAmount, float actualAmount) {
        super(size, maxAmount, actualAmount);
    }
}
