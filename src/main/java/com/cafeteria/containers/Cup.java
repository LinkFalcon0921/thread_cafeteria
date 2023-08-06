package com.cafeteria.containers;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cup extends Container {

    public Cup(EMeasureContainer m, EContainerSize size, float maxAmount) {
        super(m, size, maxAmount);
    }

    public Cup(EMeasureContainer m, EContainerSize size, float maxAmount, float actualAmount) {
        super(m, size, maxAmount, actualAmount);
    }
}
