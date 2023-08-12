package com.cafeteria.machines.stocks;

import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.IContainerSize;
import com.cafeteria.exceptions.containers.creators.IssueMachineExceptionCreator;
import com.cafeteria.exceptions.stocks.UndoneException;
import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.IGrain;
import com.cafeteria.managers.validators.grains.GrainValidator;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public class StockMachine {
    private final Stocks stocks;
    private final GrainValidator grainValidator;
    //    private final ComplementValidator complementValidator;
    private final IssueMachineExceptionCreator EXCEPTION_CREATOR;

    public StockMachine() {
        stocks = new Stocks();
        this.grainValidator = new GrainValidator();
//        this.complementValidator = new ComplementValidator();
        this.EXCEPTION_CREATOR = IssueMachineExceptionCreator.getCreator();
    }

    public boolean addStock(IGrain g) {
        try {
            return this.stocks.addGrains(g);
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
            return this.stocks.addComplements(g);
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

    @NonNull
    public Optional<IGrain> getStock(@NonNull EGrainsType grainsType, @NonNull IContainerSize containerDetails) {

        Optional<IGrain> stocksGrain = this.stocks.getGrain(grainsType);

        final int requiredGrains = containerDetails
                .getRequiredGrainCount();

        if (!this.grainValidator.hasEnough(stocksGrain, requiredGrains)) {
            throw EXCEPTION_CREATOR.createNoEnoughGrainsException();
        }

        return stocksGrain.orElseThrow().withdraw(requiredGrains);
    }

    public boolean cleanStocks() throws UndoneException {
        try {
            this.stocks.cleanUp();
            return true;
        } catch (UndoneException e) {
            throw e;
        }
    }
}
