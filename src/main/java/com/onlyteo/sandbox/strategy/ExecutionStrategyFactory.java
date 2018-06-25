package com.onlyteo.sandbox.strategy;

import java.util.List;

public interface ExecutionStrategyFactory<T, U> {

    List<ExecutionStrategy<T, U>> filterExecutionStrategies(Class<? extends ExecutionStrategy> executionStrategy);
}
