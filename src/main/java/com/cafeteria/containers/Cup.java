package com.cafeteria.containers;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cup extends Container {

    public Cup(ESizeContainer size, float amount) {
        super(size, amount);
    }
}
