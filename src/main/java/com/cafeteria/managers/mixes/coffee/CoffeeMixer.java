package com.cafeteria.managers.mixes.coffee;

import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.coffee.Coffee;
import com.cafeteria.managers.mixes.Mixer;


public class CoffeeMixer extends Mixer<ECoffeeMix, Coffee> {

    public CoffeeMixer() {
        super(EGrainsType.COFFEE);
    }

}
