package com.onlyteo.sandbox.strategy;

import org.springframework.stereotype.Component;

@Component
public class TestOrderedExecutionStrategyProvider extends OrderedExecutionStrategyProvider<String, String> {

    protected TestOrderedExecutionStrategyProvider(TestTypedExecutionStrategyFactory executionStrategiesFactory) {
        super(executionStrategiesFactory.filterExecutionStrategies(ExecutionStrategy.class));
    }

    @Override
    public void validateInput(String input) {
    }

    @Override
    public void zeroStrategiesSelected(String input) {
        throw new ExecutionStrategyException("");
    }
}
