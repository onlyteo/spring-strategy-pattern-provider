package com.onlyteo.sandbox.strategy;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.Assert;

public abstract class MultipleExecutionStrategyProvider<T, U> implements ExecutionStrategyProvider<T, List<U>> {

    private final List<? extends ExecutionStrategy<T, U>> executionStrategies;

    protected MultipleExecutionStrategyProvider(final List<? extends ExecutionStrategy<T, U>> executionStrategies) {
        Assert.notNull(executionStrategies, "Execution strategies are null");
        this.executionStrategies = executionStrategies;
    }

    @Override
    public void multipleStrategiesSelected(T input) {
    }

    @Override
    public List<U> execute(T input) {
        validateInput(input);

        List<? extends ExecutionStrategy<T, U>> selectedStrategies = executionStrategies.stream()
                .filter(strategy -> strategy.shouldExecute(input))
                .collect(Collectors.toList());

        if (selectedStrategies.isEmpty()) {
            zeroStrategiesSelected(input);
        }

        if (selectedStrategies.size() > 1) {
            multipleStrategiesSelected(input);
        }

        return selectedStrategies.stream()
                .map(strategy -> strategy.execute(input))
                .collect(Collectors.toList());
    }
}
