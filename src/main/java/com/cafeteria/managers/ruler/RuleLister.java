package com.cafeteria.managers.ruler;

import com.cafeteria.grains.IGrains;
import com.cafeteria.managers.ruler.EContainerSize;

public interface RuleLister {
    float SMALL_COFFEE = 7;
    float MEDIUM_COFFEE = 13;
    float BIG_COFFEE = 16;

    boolean isApplicable(EContainerSize s, IGrains g);
}