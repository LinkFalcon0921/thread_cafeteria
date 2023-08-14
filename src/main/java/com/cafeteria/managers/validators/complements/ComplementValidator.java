package com.cafeteria.managers.validators.complements;

import com.cafeteria.complements.IComplement;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Optional;

@NoArgsConstructor
public class ComplementValidator implements IComplementValidator {

    @Override
    public boolean hasEnough(@NonNull Optional<? extends IComplement> optionalIComplement, float amountRequired) {
        return optionalIComplement.filter(c -> c.getAmount() >= amountRequired).isPresent();
    }
}
