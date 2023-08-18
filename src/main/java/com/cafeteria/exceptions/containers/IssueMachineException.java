package com.cafeteria.exceptions.containers;

public class IssueMachineException extends RuntimeException{

    public IssueMachineException(String message) {
        super(message);
    }

    public IssueMachineException(String message, Object... args) {
        super(message.formatted(args));
    }
}
