package com.cafeteria.managers.validators.coffee;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.grains.IGrains;
import lombok.NonNull;

public class CoffeeGrainsValidator implements ICoffeeGrainsValidator {

    @Override
    public boolean isApplicable(@NonNull EContainerSize s, IGrains g) {
        int result = switch (s) {
            case BIG -> Integer.compare(BIG_COFFEE_GRAINS, g.getAmount());
            case MEDIUM -> Integer.compare(MEDIUM_COFFEE_GRAINS, g.getAmount());
            case SMALL -> Integer.compare(SMALL_COFFEE_GRAINS, g.getAmount());
        };

        return result <= 0;
    }

}
