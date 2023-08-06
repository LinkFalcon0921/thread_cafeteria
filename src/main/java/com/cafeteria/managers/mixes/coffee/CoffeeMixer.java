package com.cafeteria.managers.mixes.coffee;

import com.cafeteria.grains.coffee.Coffee;
import lombok.NonNull;

public class CoffeeMixer implements IMixer<ECoffeeMix, Coffee> {
    @Override
    public float mixGrains(@NonNull ECoffeeMix e, @NonNull Coffee g) {
        return g.getAmount() * e.MIX_VAL;
    }



}
