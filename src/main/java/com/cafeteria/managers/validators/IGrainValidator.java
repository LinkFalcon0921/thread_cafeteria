package com.cafeteria.managers.validators;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.IContainerSize;
import com.cafeteria.grains.IGrain;
import com.cafeteria.managers.factories.getters.containers.IGrainContainerGetterManager;
import lombok.NonNull;

import java.util.Optional;

public interface IGrainValidator {
    boolean hasEnough(@NonNull Optional<? extends IGrain> g, @NonNull int amountRequired);
}