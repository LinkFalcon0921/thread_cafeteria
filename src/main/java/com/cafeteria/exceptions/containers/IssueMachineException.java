package com.cafeteria.exceptions.containers;

import com.cafeteria.complements.IComplement;

public class IssueMachineException extends RuntimeException{

    public IssueMachineException(String message) {
        super(message);
    }

    public IssueMachineException(String message, Object... args) {
        super(message);
    }
}
