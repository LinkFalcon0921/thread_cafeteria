package com.cafeteria.exceptions.containers.creators;

import com.cafeteria.complements.EComplementType;
import com.cafeteria.complements.IComplement;
import com.cafeteria.exceptions.IMessages;
import com.cafeteria.exceptions.containers.IssueMachineException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IssueMachineExceptionCreator {

    private static IssueMachineExceptionCreator creator;

    public static IssueMachineExceptionCreator getCreator() {
        if (Objects.isNull(creator)) {
            creator = new IssueMachineExceptionCreator();
        }

        return creator;
    }

    public IssueMachineException createNoEnoughGrainsException() {
        return new IssueMachineException(IMessages.Issues.NOT_ENOUGH_GRAINS);
    }

    public IssueMachineException createNoEnoughComplementsException(EComplementType complement) {
        return new IssueMachineException(IMessages.Issues.NOT_ENOUGH_COMPLEMENT,
                complement);
    }
}
