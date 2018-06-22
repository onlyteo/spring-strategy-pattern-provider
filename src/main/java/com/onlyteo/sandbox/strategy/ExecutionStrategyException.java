package com.onlyteo.sandbox.strategy;

public class ExecutionStrategyException extends RuntimeException {

    public ExecutionStrategyException(String message) {
        super(message);
    }

    public ExecutionStrategyException(String message, Throwable cause) {
        super(message, cause);
    }
}
