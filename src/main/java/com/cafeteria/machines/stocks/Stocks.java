package com.cafeteria.machines.stocks;

import com.cafeteria.actioners.iterators.IteratorManager;
import com.cafeteria.complements.EComplementType;
import com.cafeteria.complements.IComplement;
import com.cafeteria.exceptions.IMessages;
import com.cafeteria.exceptions.stocks.UndoneException;
import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.IGrain;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

@NoArgsConstructor
public class Stocks {

    private Set<IGrain> grainsStock;
    private Set<IComplement> complementStock;

    public boolean addGrains(IGrain g) {
        if (Objects.isNull(g)) {
            return false;
        }

        initiateGrainStock();

        if (!this.containsStock(g.getType())) {
            this.grainsStock.add(g);
            return true;
        }

        for (IGrain grain : this.grainsStock) {
            if (grain.equals(g)) {
                return grain.fill(g);
            }
        }

        return false;
    }

    public boolean addComplements(IComplement c) {
        if (Objects.isNull(c)) {
            return false;
        }

        initiateComplementStock();

        if (!this.containsStock(c.getType())) {
            this.complementStock.add(c);
            return true;
        }

        for (IComplement complement : this.complementStock) {
            if (complement.equals(c)) {
                return complement.fill(c);
            }
        }

        return false;
    }

    public <G extends IGrain> Optional<G> getGrain(EGrainsType type) {
        for (IGrain grain : this.grainsStock) {
            if (grain.isTypeOf(type)) {
                return (Optional<G>) Optional.of(grain);
            }
        }

        return Optional.empty();
    }

    public Optional<IComplement> getComplement(EComplementType type) {
        for (IComplement complement : this.complementStock) {
            if (complement.isTypeOf(type)) {
                return Optional.of(complement);
            }
        }

        return Optional.empty();
    }


    public boolean containsStock(@NonNull EGrainsType g) {
        Predicate<IGrain> checker = grain -> grain.isTypeOf(g);

        return IteratorManager.create(this.grainsStock)
                .checkIfMatch(checker);
    }

    public boolean containsStock(@NonNull EComplementType c) {
        Predicate<IComplement> checker = grain -> grain.isTypeOf(c);

        return IteratorManager.create(this.complementStock)
                .checkIfMatch(checker);
    }

    // PRIVATE METHODS

    private void initiateGrainStock() {
        if (Objects.nonNull(this.grainsStock)) {
            return;
        }

        this.grainsStock = new HashSet<>();
    }

    private void initiateComplementStock() {
        if (Objects.nonNull(this.complementStock)) {
            return;
        }

        this.complementStock = new HashSet<>();
    }

    public void cleanUp() throws UndoneException {
        try {
            if (Objects.nonNull(this.grainsStock)) {
                this.grainsStock.clear();
            }

            if (Objects.nonNull(this.complementStock)) {
                this.complementStock.clear();
            }
        } catch (Exception e) {
            throw new UndoneException(IMessages.INoDone.MACHINE_UNABLE_CLEAN);
        }
    }
}
