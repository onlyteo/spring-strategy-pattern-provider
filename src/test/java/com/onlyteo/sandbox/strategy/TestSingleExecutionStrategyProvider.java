package com.onlyteo.sandbox.strategy;

import org.springframework.stereotype.Component;

@Component
public class TestSingleExecutionStrategyProvider extends SingleExecutionStrategyProvider<String, String> {

    protected TestSingleExecutionStrategyProvider(TestAnnotatedExecutionStrategyFactory executionStrategiesFactory) {
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
