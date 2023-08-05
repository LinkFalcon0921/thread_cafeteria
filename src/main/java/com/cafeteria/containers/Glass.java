package com.cafeteria.containers;

import lombok.*;

@Setter
@Getter
public class Glass extends Container{
    public Glass(EMeasureContainer m, EContainerSize size, float amount) {
        super(m, size, amount);
    }
}
