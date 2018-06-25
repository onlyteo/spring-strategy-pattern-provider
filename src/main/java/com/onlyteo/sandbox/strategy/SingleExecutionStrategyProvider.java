package com.onlyteo.sandbox.strategy;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.Assert;

public abstract class SingleExecutionStrategyProvider<T, U> implements ExecutionStrategyProvider<T, U> {

    private final List<? extends ExecutionStrategy<T, U>> executionStrategies;

    protected SingleExecutionStrategyProvider(final List<? extends ExecutionStrategy<T, U>> executionStrategies) {
        Assert.notNull(executionStrategies, "Execution strategies are null");
        this.executionStrategies = executionStrategies;
    }

    @Override
    public void multipleStrategiesSelected(T input) {
        throw new ExecutionStrategyException("Multiple execution strategies found for input");
    }

    @Override
    public U execute(T input) {
        validateInput(input);

        List<? extends ExecutionStrategy<T, U>> selectedStrategies = executionStrategies.stream().filter(strategy -> strategy.shouldExecute(input)).collect(Collectors.toList());

        if (selectedStrategies.isEmpty()) {
            zeroStrategiesSelected(input);
        }

        if (selectedStrategies.size() > 1) {
            multipleStrategiesSelected(input);
        }

        return selectedStrategies.stream().findFirst().map(strategy -> strategy.execute(input)).orElse(null);
    }
}
