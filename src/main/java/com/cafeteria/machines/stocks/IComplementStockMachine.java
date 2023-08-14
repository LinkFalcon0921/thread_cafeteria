package com.cafeteria.machines.stocks;

import com.cafeteria.complements.EComplementType;
import com.cafeteria.complements.IComplement;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.exceptions.stocks.UndoneException;
import lombok.NonNull;

import java.util.Optional;

public interface IComplementStockMachine {

    @NonNull
    Optional<IComplement> getStock(@NonNull EComplementType complementType, float amountRequired)
            throws IssueMachineException;

    void cleanStocks() throws UndoneException;
}
