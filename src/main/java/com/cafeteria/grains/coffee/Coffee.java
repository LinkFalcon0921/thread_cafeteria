package com.cafeteria.grains.coffee;

import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.Grain;
import com.cafeteria.grains.IGrain;
import lombok.NonNull;

import java.util.Optional;

public class Coffee extends Grain {
    public Coffee(int amount) {
        super(EGrainsType.COFFEE, amount);
    }

    @Override
    protected IGrain getInstance(int amount) {
        return new Coffee(amount);
    }
}
