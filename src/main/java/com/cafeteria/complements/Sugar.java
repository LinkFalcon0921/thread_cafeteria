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
    public void increaseAmount(int amount) {
        setAmount(getAmount() + amount);
    }

    @Override
    public void increaseAmount() {
        increaseAmount(1);
    }

    @Override
    public void decreaseAmount(int amount) {
        setAmount(getAmount() - amount);
    }

    @Override
    public void decreaseAmount() {
        decreaseAmount(1);
    }
}
