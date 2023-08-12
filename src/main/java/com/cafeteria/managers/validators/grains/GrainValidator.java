package com.cafeteria.managers.validators.grains;

import com.cafeteria.grains.IGrain;
import com.cafeteria.managers.validators.IGrainValidator;
import lombok.NonNull;

import java.util.Optional;

public class GrainValidator implements IGrainValidator {

    public GrainValidator() {
    }

    @Override
    public boolean hasEnough(@NonNull Optional<? extends IGrain> grain, int amountRequired) {
        return grain.filter(iGrain -> iGrain.getAmount() >= amountRequired).isPresent();
    }
}
