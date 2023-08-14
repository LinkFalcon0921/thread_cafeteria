package com.cafeteria.managers.validators.complements;

import com.cafeteria.complements.IComplement;
import lombok.NonNull;

import java.util.Optional;

public interface IComplementValidator {
    boolean hasEnough(@NonNull Optional<? extends IComplement> optionalIComplement, float amountRequired);

}
