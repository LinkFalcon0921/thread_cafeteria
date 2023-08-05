package com.cafeteria.complements;

public interface IComplement {
    int getAmount();

    void increaseAmount(final int amount);
    void increaseAmount();
    void decreaseAmount(final int amount);
    void decreaseAmount();
}
