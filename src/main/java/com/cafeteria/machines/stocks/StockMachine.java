package com.cafeteria.machines.stocks;

import com.cafeteria.complements.EComplementType;
import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.IContainerSize;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.exceptions.containers.creators.IssueMachineExceptionCreator;
import com.cafeteria.exceptions.stocks.UndoneException;
import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.IGrain;
import com.cafeteria.managers.validators.complements.ComplementValidator;
import com.cafeteria.managers.validators.complements.IComplementValidator;
import com.cafeteria.managers.validators.grains.GrainValidator;
import com.cafeteria.managers.validators.grains.IGrainValidator;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public class StockMachine {
    private final Stocks stocks;
    private final IGrainValidator grainValidator;
    private final IComplementValidator complementValidator;
    private final IssueMachineExceptionCreator EXCEPTION_CREATOR;

    public StockMachine() {
        stocks = new Stocks();
        this.grainValidator = new GrainValidator();
        this.complementValidator = new ComplementValidator();
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
    public Optional<IGrain> getStock(@NonNull EGrainsType grainsType, @NonNull IContainerSize containerDetails)
            throws IssueMachineException {

        Optional<IGrain> stocksGrain = this.stocks.getGrain(grainsType);

        final int requiredGrains = containerDetails
                .getRequiredGrainCount();

        if (!this.grainValidator.hasEnough(stocksGrain, requiredGrains)) {
            throw EXCEPTION_CREATOR.createNoEnoughGrainsException();
        }

        return stocksGrain.orElseThrow().withdraw(requiredGrains);
    }

    @NonNull
    public Optional<IComplement> getStock(@NonNull EComplementType complementType, float amountRequired)
            throws IssueMachineException {

        Optional<IComplement> stocksComplement = this.stocks.getComplement(complementType);

        if (this.complementValidator.hasEnough(stocksComplement, amountRequired)) {
            throw this.EXCEPTION_CREATOR.createNoEnoughComplementsException(complementType);
        }

        return stocksComplement.orElseThrow().withdraw(amountRequired);
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
