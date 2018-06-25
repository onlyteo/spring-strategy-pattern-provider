package com.onlyteo.sandbox.strategy;

public interface ExecutionStrategy<T, U> {

    boolean shouldExecute(T input);

    int order();

    U execute(T input);
}
