package com.onlyteo.sandbox.strategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.util.Assert;

public abstract class AnnotatedExecutionStrategyFactory<T, U> implements ExecutionStrategyFactory<T, U> {

    private final List<? extends ExecutionStrategy<T, U>> executionStrategies;

    protected AnnotatedExecutionStrategyFactory(final List<? extends ExecutionStrategy<T, U>> executionStrategies) {
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
        if (executionStrategy == null) {
            return null;
        }

        Strategy strategy = executionStrategy.getClass().getAnnotation(Strategy.class);

        List<Class<? extends ExecutionStrategy>> executionStrategyTypes = Optional.ofNullable(strategy)
                .map(Strategy::types).map(Arrays::asList)
                .orElseGet(Collections::emptyList);

        return filterExecutionStrategy(executionStrategy, executionStrategyTypes, executionStrategyType);
    }

    private ExecutionStrategy<T, U> filterExecutionStrategy(ExecutionStrategy<T, U> executionStrategy,
                                                            List<Class<? extends ExecutionStrategy>> executionStrategyTypes,
                                                            Class<? extends ExecutionStrategy> executionStrategyType) {
        if (executionStrategyTypes.stream().anyMatch(executionStrategyType::equals)) {
            return executionStrategy;
        } else {
            return null;
        }
    }
}
