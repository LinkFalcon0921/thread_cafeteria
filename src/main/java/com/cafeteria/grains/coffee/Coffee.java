package com.cafeteria.grains.coffee;

import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.Grain;

public class Coffee extends Grain {
    public Coffee(int amount) {
        super(EGrainsType.CAFE, amount);
    }
}
