package com.cafeteria.machines.stocks;

import com.cafeteria.containers.IContainerSize;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.exceptions.stocks.UndoneException;
import com.cafeteria.grains.EGrainsType;
import com.cafeteria.grains.IGrain;
import lombok.NonNull;

import java.util.Optional;

public interface IGrainStockMachine {

    @NonNull
    Optional<IGrain> getStock(@NonNull EGrainsType complementType, IContainerSize containerSize)
            throws IssueMachineException;

    void cleanStocks() throws UndoneException;
}
