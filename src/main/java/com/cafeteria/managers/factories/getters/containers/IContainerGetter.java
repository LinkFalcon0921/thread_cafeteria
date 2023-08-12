package com.cafeteria.managers.factories.getters.containers;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.IContainerSize;
import lombok.NonNull;

public interface IContainerGetter<E extends IContainerSize> {
    E getDetailsOf(EContainerSize containerSize);
}
