package com.cafeteria.managers.ruler;

import com.cafeteria.grains.IGrains;
import com.cafeteria.containers.EContainerSize;

public interface RuleAmount {
    int SMALL_COFFEE_GRAINS = 7;
    int MEDIUM_COFFEE_GRAINS = 13;
    int BIG_COFFEE_GRAINS = 16;

    boolean isApplicable(EContainerSize s, IGrains g);
}