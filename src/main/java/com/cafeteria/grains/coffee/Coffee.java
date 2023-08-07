package com.cafeteria.grains.coffee;

import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.Grain;
import com.cafeteria.grains.IGrain;
import lombok.NonNull;

import java.util.Optional;

public class Coffee extends Grain {
    public Coffee(int amount) {
        super(EGrainsType.CAFE, amount);
    }

    @Override
    public boolean fill(@NonNull IGrain grain) {
        if(!grain.isTypeOf(getType())){
            return false;
        }

        final int coffeeAmount = grain.getAmount();

        if(coffeeAmount < 0){
            return false;
        }

        this.amount += coffeeAmount;
        return true;
    }

    @Override
    public Optional<IGrain> withdraw(Integer amount) {
        if(amount <= 0){
            return Optional.empty();
        }

        this.amount -= amount;

        return Optional.of(new Coffee(amount));
    }
}
