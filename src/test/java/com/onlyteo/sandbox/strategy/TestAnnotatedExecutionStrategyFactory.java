package com.onlyteo.sandbox.strategy;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TestAnnotatedExecutionStrategyFactory extends AnnotatedExecutionStrategyFactory<String, String> {

    protected TestAnnotatedExecutionStrategyFactory(List<ExecutionStrategy<String, String>> executionStrategies) {
        super(executionStrategies);
    }
}
