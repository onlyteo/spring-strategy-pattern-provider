package com.onlyteo.sandbox.strategy;

public interface ExecutionStrategyProvider<T, U> {

    void validateInput(T input);

    void zeroStrategiesSelected(T input);

    void multipleStrategiesSelected(T input);

    U execute(T input);
}
