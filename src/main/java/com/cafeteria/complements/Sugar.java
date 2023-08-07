package com.cafeteria.complements;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Optional;

@Setter
@Getter
@AllArgsConstructor
public class Sugar implements IComplement {
    private final EPortion portion;
    private float amount;


    @Override
    public boolean fill(@NonNull IComplement complement) {
        if (!complement.isTypeOf(getType())) {
            return false;
        }

        final float coffeeAmount = complement.getAmount();

        if (coffeeAmount < 0) {
            return false;
        }

        this.amount += coffeeAmount;
        return true;
    }

    @Override
    public Optional<IComplement> withdraw(Float amount) {
        if (amount <= 0) {
            return Optional.empty();
        }

        this.amount -= amount;
        return Optional.of(new Sugar(EPortion.tbsp, amount));
    }

    @Override
    public boolean isTypeOf(EComplementType type) {
        return getType().equals(type);
    }

    @Override
    public EComplementType getType() {
        return EComplementType.SUGAR;
    }
}
