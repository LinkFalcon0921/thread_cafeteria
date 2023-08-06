package com.cafeteria.managers.mixes.coffee;

import com.cafeteria.grains.IGrains;
import com.cafeteria.grains.coffee.Coffee;
import lombok.NonNull;

public class CoffeeMixer implements IMixer<ECoffeeMixes, Coffee> {
    @Override
    public float mixGrains(ECoffeeMixes e, Coffee g) {


        return g.getAmount() * e.MIX_VAL;
    }

}
