package com.cafeteria.managers.validators.grains;

import com.cafeteria.grains.IGrain;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Optional;

@NoArgsConstructor
public class GrainValidator implements IGrainValidator {

    @Override
    public boolean hasEnough(@NonNull Optional<? extends IGrain> grain, int amountRequired) {
        return grain.filter(iGrain -> iGrain.getAmount() >= amountRequired).isPresent();
    }
}
