package com.cafeteria.machines;

import com.cafeteria.complements.EComplementType;
import com.cafeteria.complements.IComplement;
import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.IGrain;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@NoArgsConstructor
public class Stocks {

    private Set<IGrain> grainsStock;
    private Set<IComplement> complementStock;

    public boolean addGrains(IGrain g) {
        initiateGrainStock();

        if (!containsStock(g)) {
            this.grainsStock.add(g);
            return true;
        }

        for (IGrain grain : this.grainsStock) {
            if (grain.equals(g)) {
                grain.fill(g);
                return true;
            }
        }

        return false;
    }

    public boolean addComplements(IComplement c) {
        initiateComplementStock();

        if (!containsStock(c)) {
            this.complementStock.add(c);
            return true;
        }

        for (IComplement complement : this.complementStock) {
            if (complement.equals(c)) {
                complement.fill(c);
                return true;
            }
        }

        return false;
    }

    public Optional<IGrain> getGrain(EGrainsType type) {
        for (IGrain grain : this.grainsStock) {
            if (grain.isTypeOf(type)) {
                return Optional.of(grain);
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


    public boolean containsStock(IComplement c) {
        return this.complementStock.contains(c);
    }

    public boolean containsStock(IGrain g) {
        return this.grainsStock.contains(g);
    }

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

}
