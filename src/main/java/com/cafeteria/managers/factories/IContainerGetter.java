package com.cafeteria.managers.factories;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import lombok.NonNull;

public interface IContainerGetter<E extends Enum<E>> {
    E getDetailsOf(EContainerSize containerSize);
}
