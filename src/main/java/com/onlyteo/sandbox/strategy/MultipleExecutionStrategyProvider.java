package com.onlyteo.sandbox.strategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.util.Assert;

public abstract class MultipleExecutionStrategyProvider<T, U> implements ExecutionStrategyProvider<T, List<U>> {

    private final List<ExecutionStrategy<T, U>> strategies;

    protected MultipleExecutionStrategyProvider(final List<ExecutionStrategy<T, U>> strategies) {
        Assert.notEmpty(strategies, "Null or zero strategies applied");
        this.strategies = strategies;
    }

    @Override
    public void multipleStrategiesSelected(T input) {
    }

    @Override
    public List<U> execute(T input) {
        Stream<ExecutionStrategy<T, U>> selectedStrategies = strategies.stream().filter(strategy -> strategy.shouldExecute(input));
        if (selectedStrategies.count() == 0) {
            zeroStrategiesSelected(input);
        }
        if (selectedStrategies.count() > 1) {
            multipleStrategiesSelected(input);
        }
        return selectedStrategies.map(strategy -> strategy.execute(input)).collect(Collectors.toList());
    }
}
