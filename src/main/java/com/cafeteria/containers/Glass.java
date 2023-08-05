package com.cafeteria.containers;

import lombok.*;

@Setter
@Getter
public class Glass extends Container{
    public Glass(ESizeContainer size, float amount) {
        super(size, amount);
    }
}
