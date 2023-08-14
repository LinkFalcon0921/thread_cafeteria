package com.cafeteria.managers.factories.getters.containers.tea;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.sizes.tea.ETeaCupSize;
import com.cafeteria.managers.factories.getters.containers.IContainerGetter;

public class TeaCupContainerGetter implements IContainerGetter<ETeaCupSize> {
    @Override
    public ETeaCupSize getDetailsOf(EContainerSize containerSize) {
        return ETeaCupSize.getBySize(containerSize);
    }
}
