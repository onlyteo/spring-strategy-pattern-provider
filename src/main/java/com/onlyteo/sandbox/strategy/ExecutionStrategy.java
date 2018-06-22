package com.onlyteo.sandbox.strategy;

public interface ExecutionStrategy<T, U> {

    boolean shouldExecute(T input);

    U execute(T input);
}
