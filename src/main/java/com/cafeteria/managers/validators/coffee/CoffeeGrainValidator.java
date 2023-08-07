package com.cafeteria.managers.validators.coffee;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.containers.sizes.coffee.IContainerSize;
import com.cafeteria.exceptions.containers.creators.IssueMachineExceptionCreator;
import com.cafeteria.grains.IGrain;
import com.cafeteria.grains.coffee.Coffee;
import com.cafeteria.managers.factories.CoffeeContainerGetterManager;
import lombok.NonNull;

import java.util.Optional;

public class CoffeeGrainValidator implements ICoffeeGrainsValidator<Coffee> {

    private final IssueMachineExceptionCreator EXCEPTION_CREATOR;
    private final CoffeeContainerGetterManager coffeeContainerManager;

    public CoffeeGrainValidator() {
        this.EXCEPTION_CREATOR = IssueMachineExceptionCreator.getCreator();
        coffeeContainerManager = new CoffeeContainerGetterManager();
    }

    @Override
    public boolean isThereEnough(@NonNull Optional<Coffee> coffee, @NonNull int amountRequired) {
        return coffee.filter(iGrain -> amountRequired <= iGrain.getAmount()).isPresent();
    }

    public IContainerSize getRequiredGrain(@NonNull EContainerType containerType, @NonNull EContainerSize containerSize) {
        return this.coffeeContainerManager.getGrainContainerDetails(containerType, containerSize);
    }
}
