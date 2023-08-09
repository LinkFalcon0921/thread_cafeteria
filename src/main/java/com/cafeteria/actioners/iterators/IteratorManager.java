package com.cafeteria.actioners.iterators;


import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class IteratorManager<E> {

    private final Collection<E> collection;

    private IteratorManager(Collection<E> collection) {
        this.collection = collection;
    }

    @NotNull
    public static <EX> IteratorManager<EX> create(@NonNull Collection<EX> c) {
        return new IteratorManager<>(c);
    }

    public <R> Optional<R> iterateToGet(@NonNull Function<E, R> action, @NotNull Predicate<E> validator) {
        if (this.collection.size() < 70) {
            return this.iterateByFor(action, validator);
        }

        return this.iterateByStream(action, validator);
    }

    private <R> Optional<R> iterateByFor(Function<E, R> action, Predicate<E> validator) {
        for (E e : this.collection) {
            if (validator.test(e)) {
                return Optional.ofNullable(action.apply(e));
            }
        }

        return Optional.empty();
    }

    private <R> Optional<R> iterateByStream(Function<E, R> action, Predicate<E> validator) {
        return this.collection.stream()
                .filter(validator)
                .findFirst()
                .map(action);
    }

    public boolean checkIfMatch(Predicate<E> checker) {
        boolean value = false;

        for (E e : this.collection) {
            if (checker.test(e)) {
                value = true;
                break;
            }
        }

        return value;
    }
}
