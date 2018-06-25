package com.onlyteo.sandbox.strategy;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.Assert;

public abstract class TypedExecutionStrategyFactory<T, U> implements ExecutionStrategyFactory<T, U> {

    private final List<? extends ExecutionStrategy<T, U>> executionStrategies;

    protected TypedExecutionStrategyFactory(final List<? extends ExecutionStrategy<T, U>> executionStrategies) {
        Assert.notNull(executionStrategies, "Execution strategies are null");

        this.executionStrategies = executionStrategies;
    }

    @Override
    public List<ExecutionStrategy<T, U>> filterExecutionStrategies(Class<? extends ExecutionStrategy> executionStrategyType) {
        Assert.notNull(executionStrategyType, "Strategy type is null");

        return executionStrategies.stream()
                .map(executionStrategy -> filterExecutionStrategy(executionStrategy, executionStrategyType))
                .collect(Collectors.toList());
    }

    private ExecutionStrategy<T, U> filterExecutionStrategy(ExecutionStrategy<T, U> executionStrategy, Class<? extends ExecutionStrategy> executionStrategyType) {
        if (executionStrategy != null && executionStrategyType.isAssignableFrom(executionStrategy.getClass())) {
            return executionStrategy;
        }

        return null;
    }
}
