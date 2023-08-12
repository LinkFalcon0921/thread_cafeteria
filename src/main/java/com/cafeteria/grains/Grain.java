package com.cafeteria.grains;

import com.cafeteria.grains.coffee.Coffee;
import lombok.*;

import java.util.Optional;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public abstract class Grain implements IGrain {
    protected EGrainsType type;
    protected int amount;

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

    @Override
    public boolean isTypeOf(@NonNull EGrainsType type) {
        return this.getType().equals(type);
    }
}
