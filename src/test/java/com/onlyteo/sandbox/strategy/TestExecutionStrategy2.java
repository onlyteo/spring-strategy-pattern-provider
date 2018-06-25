package com.onlyteo.sandbox.strategy;

@Strategy
public class TestExecutionStrategy2 implements ExecutionStrategy<String, String> {

    @Override
    public boolean shouldExecute(String input) {
        return input != null && input.contains("TWO");
    }

    @Override
    public int order() {
        return 3;
    }

    @Override
    public String execute(String input) {
        return "TWO_EXECUTED";
    }
}
