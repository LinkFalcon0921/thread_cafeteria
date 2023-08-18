package com.cafeteria.grains.tea;

import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.Grain;
import com.cafeteria.grains.IGrain;

public class Tea extends Grain {

    public Tea(int amount) {
        super(EGrainsType.TEA, amount);
    }

    @Override
    protected IGrain getInstance(int amount) {
        return new Tea(amount);
    }
}
