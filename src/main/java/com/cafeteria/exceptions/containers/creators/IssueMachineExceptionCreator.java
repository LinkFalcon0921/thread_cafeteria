package com.cafeteria.exceptions.containers.creators;

import com.cafeteria.exceptions.IMessages;
import com.cafeteria.exceptions.containers.IssueMachineException;
import com.cafeteria.fields.IClassifiableStock;
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

    public IssueMachineException createNoEnoughStockException(IClassifiableStock complement) {
        return new IssueMachineException(IMessages.Issues.NOT_ENOUGH_STOCK,
                complement);
    }

    public IssueMachineException createNoStockOfException(IClassifiableStock stockType) {
        return new IssueMachineException(IMessages.Issues.ANY_STOCK_OF,
                stockType);
    }
}
