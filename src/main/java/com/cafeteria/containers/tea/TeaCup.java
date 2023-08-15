package com.cafeteria.containers.tea;

import com.cafeteria.containers.Cup;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.sizes.tea.ETeaCupSize;


public class TeaCup extends Cup<ETeaCupSize> {
    public TeaCup(EContainerSize size, float maxAmount) {
        super(size, maxAmount);
    }

    public TeaCup(EContainerSize size, float maxAmount, float actualAmount) {
        super(size, maxAmount, actualAmount);
    }

    @Override
    public ETeaCupSize getSize() {
        return ETeaCupSize.getBySize(this.SIZE);
    }
}
