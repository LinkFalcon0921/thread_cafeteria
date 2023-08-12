package com.cafeteria.grains.tea;

import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.Grain;

public class Tea extends Grain {

    public Tea(int amount) {
        super(EGrainsType.TEA, amount);
    }
}
