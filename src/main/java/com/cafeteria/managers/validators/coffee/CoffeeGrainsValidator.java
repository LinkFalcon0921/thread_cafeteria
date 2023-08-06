package com.cafeteria.managers.validators.coffee;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.grains.IGrains;
import lombok.NonNull;

public class CoffeeGrainsValidator implements ICoffeeGrainsValidator {

    @Override
    public boolean isApplicable(@NonNull EContainerSize s, @NonNull IGrains g) {
        int result = switch (s) {
            case BIG -> BIG_COFFEE_GRAINS;
            case MEDIUM -> MEDIUM_COFFEE_GRAINS;
            case SMALL -> SMALL_COFFEE_GRAINS;
        };

        return result <= g.getAmount();
    }

}
