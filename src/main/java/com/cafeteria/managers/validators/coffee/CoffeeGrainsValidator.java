package com.cafeteria.managers.validators.coffee;

import com.cafeteria.containers.EContainerSize;
import com.cafeteria.exceptions.containers.IMessages;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.IGrain;
import com.cafeteria.grains.coffee.Coffee;
import com.cafeteria.machines.StockMachine;
import lombok.NonNull;

import java.util.Optional;

public class CoffeeGrainsValidator implements ICoffeeGrainsValidator {

    public void checkGrain(StockMachine stocks, EContainerSize size) {
        Optional<Coffee> coffee = stocks.getStock(EGrainsType.CAFE);

        if (coffee.isEmpty() || !isApplicable(size, coffee.get())) {
            throw new IssueMachineException(IMessages.Issues.NOT_ENOUGH_GRAINS);
        }

        coffee.get().withdraw(this.getRequiredGrain(size));
    }

    @Override
    public boolean isApplicable(@NonNull EContainerSize s, @NonNull IGrain g) {
        int result = getRequiredGrain(s);

        return result <= g.getAmount();
    }

    protected int getRequiredGrain(EContainerSize s) {
        return switch (s) {
            case BIG -> BIG_COFFEE_GRAINS;
            case MEDIUM -> MEDIUM_COFFEE_GRAINS;
            case SMALL -> SMALL_COFFEE_GRAINS;
        };
    }

}
