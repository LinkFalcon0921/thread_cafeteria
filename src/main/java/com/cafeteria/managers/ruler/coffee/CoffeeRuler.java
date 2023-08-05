package com.cafeteria.managers.ruler.coffee;

import com.cafeteria.grains.IGrains;
import com.cafeteria.managers.ruler.RuleLister;
import com.cafeteria.managers.ruler.EContainerSize;
import lombok.NonNull;

public class CoffeeRuler implements RuleLister {

    @Override
    public boolean isApplicable(@NonNull EContainerSize s, IGrains g) {
        int result = switch (s) {
            case BIG -> Float.compare(g.getAmount(), BIG_COFFEE);
            case MEDIUM -> Float.compare(g.getAmount(), MEDIUM_COFFEE);
            case SMALL -> Float.compare(g.getAmount(), SMALL_COFFEE);
        };

        return result >= 0;
    }
}
