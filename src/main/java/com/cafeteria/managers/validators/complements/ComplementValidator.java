package com.cafeteria.managers.validators.complements;

import com.cafeteria.complements.IComplement;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.exceptions.containers.creators.IssueMachineExceptionCreator;
import com.cafeteria.machines.stocks.StockMachine;

import java.util.List;

public class ComplementValidator {

    private final IssueMachineExceptionCreator EXCEPTION_CREATOR;

    public ComplementValidator() {
        EXCEPTION_CREATOR = IssueMachineExceptionCreator.getCreator();
    }

    public void checkIngredients(final StockMachine stocks, final List<IComplement> complements) throws IssueMachineException {

        for (IComplement complement : complements) {
            final float stockOf = stocks.getStockAmountOf(complement.getType());

            if (complement.getAmount() > stockOf) {
                throw EXCEPTION_CREATOR.createNoEnoughComplementsException(complement);
            }
        }
    }
}
