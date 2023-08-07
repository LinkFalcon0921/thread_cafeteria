package com.cafeteria.managers.validators.coffee;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.exceptions.containers.creators.IssueMachineExceptionCreator;
import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.IGrain;
import com.cafeteria.grains.coffee.Coffee;
import com.cafeteria.machines.StockMachine;
import lombok.NonNull;

import java.util.Optional;

public class CoffeeGrainsValidator implements ICoffeeGrainsValidator {

    private final IssueMachineExceptionCreator EXCEPTION_CREATOR;

    public CoffeeGrainsValidator() {
        this.EXCEPTION_CREATOR = IssueMachineExceptionCreator.getCreator();
    }

    public void checkGrain(@NonNull StockMachine stocks, @NonNull EContainerSize containerSize, @NonNull EContainerType containerType) {
        final int requiredGrain = this.getRequiredGrain(containerType, containerSize);
        Optional<Coffee> coffee = stocks.getStock(EGrainsType.CAFE, requiredGrain);

        if (coffee.isEmpty() || !isApplicable(containerSize, coffee.get())) {

            throw EXCEPTION_CREATOR.createNoEnoughGrainsException();
        }

    }

    @Override
    public boolean isApplicable(@NonNull EContainerSize s, @NonNull IGrain g) {
        int result = getRequiredGrain(s);

        return result <= g.getAmount();
    }

    protected int getRequiredGrain(@NonNull EContainerType containerType, @NonNull EContainerSize containerSize) {
        return E
    }

}
