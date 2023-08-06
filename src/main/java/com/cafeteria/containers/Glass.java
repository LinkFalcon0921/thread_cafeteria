package com.cafeteria.containers;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Glass extends Container {
    public Glass(EContainerSize size, float maxAmount) {
        super(size, maxAmount);
    }

    public Glass(EContainerSize size, float maxAmount, float actualAmount) {
        super(size, maxAmount, actualAmount);
    }
}
