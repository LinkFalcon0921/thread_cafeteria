package com.cafeteria.managers.validators;

import com.cafeteria.grains.IGrain;
import lombok.NonNull;

import java.util.Optional;

public interface IGrainValidator {
    boolean hasEnough(@NonNull Optional<? extends IGrain> optionalIGrain, int amountRequired);
}