package com.cafeteria.containers.tea;

import com.cafeteria.containers.Cup;
import com.cafeteria.containers.EContainerSize;


public class TeaCup extends Cup {
    public TeaCup(EContainerSize size, float maxAmount) {
        super(size, maxAmount);
    }

    public TeaCup(EContainerSize size, float maxAmount, float actualAmount) {
        super(size, maxAmount, actualAmount);
    }
}
