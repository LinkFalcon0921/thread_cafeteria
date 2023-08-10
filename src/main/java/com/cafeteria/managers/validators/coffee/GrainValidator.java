package com.cafeteria.managers.validators.coffee;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.sizes.coffee.IContainerSize;
import com.cafeteria.exceptions.containers.creators.IssueMachineExceptionCreator;
import com.cafeteria.grains.Grain;
import com.cafeteria.grains.IGrain;
import com.cafeteria.managers.factories.CoffeeContainerGetterManager;
import com.cafeteria.managers.validators.IGrainValidator;
import lombok.NonNull;

import java.util.Optional;

public class GrainValidator implements IGrainValidator<IGrain> {

    private final IssueMachineExceptionCreator EXCEPTION_CREATOR;
    private final CoffeeContainerGetterManager coffeeContainerManager;

    public GrainValidator() {
        this.EXCEPTION_CREATOR = IssueMachineExceptionCreator.getCreator();
        coffeeContainerManager = new CoffeeContainerGetterManager();
    }

    @Override
    public boolean isThereEnough(@NonNull Optional<IGrain> coffee, @NonNull int amountRequired) {
        return coffee.filter(iGrain -> iGrain.getAmount() >= amountRequired).isPresent();
    }

    public IContainerSize getRequiredGrain(@NonNull EContainerType containerType, @NonNull EContainerSize containerSize) {
        return this.coffeeContainerManager.getGrainContainerDetails(containerType, containerSize);
    }
}
