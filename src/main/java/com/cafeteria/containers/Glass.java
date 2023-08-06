package com.cafeteria.containers;

import lombok.*;

@Setter
@Getter
public class Glass extends Container{
    public Glass(EMeasureContainer m, EContainerSize size, float maxAmount) {
        super(m, size, maxAmount);
    }
    public Glass(EMeasureContainer m, EContainerSize size, float maxAmount, float actualAmount) {
        super(m, size, maxAmount, actualAmount);
    }
}
