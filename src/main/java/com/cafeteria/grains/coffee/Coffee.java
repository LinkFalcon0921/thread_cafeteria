package com.cafeteria.grains.coffee;

import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.Grains;

public class Coffee extends Grains {
    public Coffee(int amount) {
        super(EGrainsType.CAFE, amount);
    }
}
