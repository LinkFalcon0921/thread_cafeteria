package com.cafeteria.managers.validators.coffee;

import com.cafeteria.grains.coffee.Coffee;
import com.cafeteria.managers.validators.IGrainValidator;

public interface ICoffeeGrainsValidator<C extends Coffee> extends IGrainValidator<C> {
}
