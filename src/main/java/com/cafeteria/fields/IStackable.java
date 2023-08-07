package com.cafeteria.fields;

import java.util.Optional;

public interface IStackable<S extends IStackable<S, V>, V extends Number> {
    boolean fill(S s);
    Optional<S> withdraw(V v);
}
