package com.cafeteria.managers.mixes.coffee;

import com.cafeteria.exceptions.containers.creators.IssueMachineExceptionCreator;
import com.cafeteria.grains.coffee.Coffee;
import lombok.NonNull;

import java.util.Optional;


public class CoffeeMixer implements IMixer<ECoffeeMix, Coffee> {

    private final IssueMachineExceptionCreator EXCEPTION_CREATOR;

    public CoffeeMixer() {
        EXCEPTION_CREATOR = IssueMachineExceptionCreator.getCreator();
    }

    @Override
    public float mixGrains(@NonNull ECoffeeMix e, @NonNull Optional<Coffee> g) {
        if (g.isEmpty()) {
            throw EXCEPTION_CREATOR.createNoEnoughGrainsException();
        }

        return g.get().getAmount() * e.mixVal;
    }
}
