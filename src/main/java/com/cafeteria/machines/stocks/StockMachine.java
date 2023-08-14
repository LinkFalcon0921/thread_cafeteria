package com.cafeteria.machines.stocks;

import com.cafeteria.complements.EComplementType;
import com.cafeteria.complements.IComplement;
import com.cafeteria.containers.IContainerSize;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.exceptions.containers.creators.IssueMachineExceptionCreator;
import com.cafeteria.exceptions.stocks.UndoneException;
import com.cafeteria.fields.IClassifiableStock;
import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.IGrain;
import com.cafeteria.managers.validators.complements.ComplementValidator;
import com.cafeteria.managers.validators.complements.IComplementValidator;
import com.cafeteria.managers.validators.grains.GrainValidator;
import com.cafeteria.managers.validators.grains.IGrainValidator;
import lombok.NonNull;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StockMachine implements IComplementStockMachine, IGrainStockMachine {
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
            if (Objects.isNull(g)) {
                throw new RuntimeException();
            }

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

    /**
     * Retrieve an {@link EGrainsType} stock.
     */
    @NonNull
    public Optional<IGrain> getStock(@NonNull EGrainsType grainsType, @NonNull IContainerSize containerDetails)
            throws IssueMachineException {

        if (!this.stocks.containsStock(grainsType)) {
            throw this.EXCEPTION_CREATOR.createNoStockOfException(grainsType);
        }

        Optional<IGrain> stocksGrain = this.stocks.getGrain(grainsType);

        final int requiredGrains = containerDetails
                .getRequiredGrainCount();

        if (!this.grainValidator.hasEnough(stocksGrain, requiredGrains)) {
            throw EXCEPTION_CREATOR.createNoEnoughStockException(grainsType);
        }

        return stocksGrain.orElseThrow().withdraw(requiredGrains);
    }

    /**
     * Retrieve an {@link EComplementType} stock.
     */
    @NonNull
    public Optional<IComplement> getStock(@NonNull EComplementType complementType, float amountRequired)
            throws IssueMachineException {

        if (!this.stocks.containsStock(complementType)) {
            throw this.EXCEPTION_CREATOR.createNoStockOfException(complementType);
        }

        Optional<IComplement> stocksComplement = this.stocks.getComplement(complementType);

        if (!this.complementValidator.hasEnough(stocksComplement, amountRequired)) {
            throw this.EXCEPTION_CREATOR.createNoEnoughStockException(complementType);
        }

        return stocksComplement.orElseThrow().withdraw(amountRequired);
    }

    /**
     * Check if there is any stock of an ingredient.
     */
    public boolean hasStockOf(@NonNull IClassifiableStock stockType) {

        if (stockType instanceof EComplementType type) {
            return this.stocks.containsStock(type);
        }

        return this.stocks.containsStock((EGrainsType) stockType);
    }

    public void cleanStocks() throws UndoneException {
        this.stocks.cleanUp();
    }
}
