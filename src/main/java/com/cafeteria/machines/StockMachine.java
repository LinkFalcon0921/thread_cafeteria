package com.cafeteria.machines;

import com.cafeteria.complements.EComplementType;
import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.EContainerSize;
import com.cafeteria.containers.EContainerType;
import com.cafeteria.exceptions.containers.creators.IssueMachineExceptionCreator;
import com.cafeteria.exceptions.stocks.UndoneException;
import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.IGrain;
import com.cafeteria.grains.coffee.Coffee;
import com.cafeteria.managers.validators.coffee.CoffeeGrainValidator;
import com.cafeteria.managers.validators.complements.ComplementValidator;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
public class StockMachine {
    private final Stocks stocks;
    private final CoffeeGrainValidator coffeeRuler;
//    private final ComplementValidator complementValidator;
    private IssueMachineExceptionCreator EXCEPTION_CREATOR;

    public StockMachine() {
        stocks = new Stocks();
        this.coffeeRuler = new CoffeeGrainValidator();
//        this.complementValidator = new ComplementValidator();
        this.EXCEPTION_CREATOR = IssueMachineExceptionCreator.getCreator();
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

    public <G extends IGrain> Optional<G> getStock(EGrainsType grainsType, EContainerType containerType,
                                                   EContainerSize containerSize) {

        Optional<Coffee> stocksGrain = this.stocks.getGrain(grainsType);

        final int requiredGrains = this.coffeeRuler
                .getRequiredGrain(containerType, containerSize)
                .getRequiredGrains();

        if (!this.coffeeRuler.isThereEnough(stocksGrain, requiredGrains)) {
            throw EXCEPTION_CREATOR.createNoEnoughGrainsException();
        }

        return (Optional<G>) stocksGrain.orElseThrow().withdraw(requiredGrains);
    }

    public <C extends IComplement> Optional<C> getStock(EComplementType c, float amount) {
        return (Optional<C>) this.stocks.getComplement(c).orElseThrow().withdraw(amount);
    }

    public int getStockOf(EGrainsType g) {
        return this.stocks.getGrain(g).orElseThrow().getAmount();
    }

    public float getStockOf(EComplementType c) {
        return this.stocks.getComplement(c).orElseThrow().getAmount();
    }

    public boolean cleanStocks() throws UndoneException {
        try {
            this.stocks.reset();
            return true;
        } catch (UndoneException e) {
            throw e;
        }
    }
}
