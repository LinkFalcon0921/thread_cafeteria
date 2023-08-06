package com.cafeteria.managers.mixes.coffee;

public enum ECoffeeMixes {
    SMALL(1.3f),
    MEDIUM(1.9f),
    BIG(2.2f);

    final float MIX_VAL;

    ECoffeeMixes(float value) {
        this.MIX_VAL = value;
    }
}
