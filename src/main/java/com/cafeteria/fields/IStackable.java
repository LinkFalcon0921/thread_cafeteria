package com.cafeteria.fields;

public interface IStackable<V extends Number> {
    void fill(V amount);
    V withdraw(V amount);
}
