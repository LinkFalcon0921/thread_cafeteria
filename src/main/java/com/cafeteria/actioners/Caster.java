package com.cafeteria.actioners;

import lombok.NonNull;

import java.util.function.Function;

public class Caster {
    private static Caster caster;

    public static Caster getInstance() {
        if (caster == null) {
            caster = new Caster();
        }

        return caster;
    }

    private Caster() {
    }

    @NonNull
    public <T, D extends T> Function<T, D> castTo(@NonNull Class<D> dClass) {
        return dClass::cast;
    }
}
