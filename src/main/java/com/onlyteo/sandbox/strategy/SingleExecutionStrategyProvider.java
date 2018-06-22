package com.onlyteo.sandbox.strategy;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.util.Assert;

public abstract class SingleExecutionStrategyProvider<T, U> implements ExecutionStrategyProvider<T, U> {

    private final List<ExecutionStrategy<T, U>> strategies;

    protected SingleExecutionStrategyProvider(final List<ExecutionStrategy<T, U>> strategies) {
        Assert.notEmpty(strategies, "Null or zero strategies applied");
        this.strategies = strategies;
    }

    @Override
    public void multipleStrategiesSelected(T input) {
        throw new ExecutionStrategyException("Multiple execution strategies found for input");
    }

    @Override
    public U execute(T input) {
        Stream<ExecutionStrategy<T, U>> selectedStrategies = strategies.stream().filter(strategy -> strategy.shouldExecute(input));
        if (selectedStrategies.count() == 0) {
            zeroStrategiesSelected(input);
        }
        if (selectedStrategies.count() > 1) {
            multipleStrategiesSelected(input);
        }
        return selectedStrategies.findFirst().map(strategy -> strategy.execute(input)).orElse(null);
    }
}
