package com.cafeteria.managers.ruler.coffee;

import com.cafeteria.grains.IGrains;
import com.cafeteria.managers.ruler.RuleAmount;
import com.cafeteria.containers.EContainerSize;
import lombok.NonNull;

public class CoffeeRuler implements RuleAmount {

    @Override
    public boolean isApplicable(@NonNull EContainerSize s, IGrains g) {
        int result = switch (s) {
            case BIG -> Integer.compare(g.getAmount(), BIG_COFFEE_GRAINS);
            case MEDIUM -> Integer.compare(g.getAmount(), MEDIUM_COFFEE_GRAINS);
            case SMALL -> Integer.compare(g.getAmount(), SMALL_COFFEE_GRAINS);
        };

        return result >= 0;
    }
}
