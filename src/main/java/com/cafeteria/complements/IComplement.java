package com.cafeteria.complements;

public interface IComplement {
    float getAmount();

    void increaseAmount(final int amount);
    void increaseAmount();
    void decreaseAmount(final int amount);
    void decreaseAmount();
}
