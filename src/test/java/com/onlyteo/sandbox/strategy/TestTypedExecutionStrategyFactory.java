package com.onlyteo.sandbox.strategy;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TestTypedExecutionStrategyFactory extends TypedExecutionStrategyFactory<String, String> {

    protected TestTypedExecutionStrategyFactory(List<ExecutionStrategy<String, String>> executionStrategies) {
        super(executionStrategies);
    }
}
