package com.cafeteria.complements;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Sugar implements IComplement{
    private float amount;
    private final EPortion portion;

    @Override
    public void fill(Float amount) {
        this.amount += amount;
    }

    @Override
    public Float withdraw(Float amount) {
        if(this.amount <= amount){
            this.amount -= amount;
            return amount;
        }

        return 0f;
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
