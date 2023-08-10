package com.cafeteria.managers.validators;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.sizes.coffee.IContainerSize;
import com.cafeteria.grains.IGrain;
import lombok.NonNull;

import java.util.Optional;

public interface IGrainValidator {
    boolean isThereEnough(@NonNull Optional<? extends IGrain> g, @NonNull int amountRequired);

    IContainerSize getRequiredGrain(@NonNull EContainerType containerType, @NonNull EContainerSize containerSize);
}