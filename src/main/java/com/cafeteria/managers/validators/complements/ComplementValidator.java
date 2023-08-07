package com.cafeteria.managers.validators.complements;

import com.cafeteria.complements.IComplement;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.machines.StockMachine;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class ComplementValidator {

    public void checkIngredients(final StockMachine stocks, final List<IComplement> complements) throws IssueMachineException {

        for (IComplement complement : complements) {
            Optional<IComplement> stockOf = stocks.getStock(complement.getType());

            if (stockOf.isEmpty() ||
                    complement.getAmount() > stockOf.get().getAmount()) {
                throw new IssueMachineException("There is not enough %s to prepare the drink.",
                        complement.getType());
            }
        }
    }
}
