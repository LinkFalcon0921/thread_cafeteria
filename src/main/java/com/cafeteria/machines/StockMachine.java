package com.cafeteria.machines;

import com.cafeteria.complements.EComplementType;
import com.cafeteria.complements.IComplement;
import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.IGrain;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
public class StockMachine {
    private final Stocks stocks;

    public StockMachine() {
        stocks = new Stocks();
    }

    public boolean addStock(IGrain g) {
        try {
            this.stocks.addGrains(g);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addGrains(List<IGrain> gList) {
        try {
            return gList.stream().allMatch(this::addStock);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addStock(IComplement g) {
        try {
            this.stocks.addComplements(g);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addComplements(List<IComplement> cList) {
        try {
            return cList.stream().allMatch(this::addStock);
        } catch (Exception e) {
            return false;
        }
    }

    public <G extends IGrain> Optional<G> getStock(EGrainsType g, int amount) {
        return (Optional<G>) this.stocks.getGrain(g, amount);
    }

    public <C extends IComplement> Optional<C> getStock(EComplementType c, float amount) {
        return (Optional<C>) this.stocks.getComplement(c, amount);
    }

    public int getStockOf(EGrainsType g) {
        return this.stocks.getGrain(g).orElseThrow().getAmount();
    }

    public float getStockOf(EComplementType c) {
        return this.stocks.getComplement(c).orElseThrow().getAmount();
    }
}
