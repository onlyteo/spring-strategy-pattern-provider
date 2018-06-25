package com.onlyteo.sandbox.strategy;

@Strategy
public class TestExecutionStrategy3 implements ExecutionStrategy<String, String> {

    @Override
    public boolean shouldExecute(String input) {
        return input != null && input.contains("THREE");
    }

    @Override
    public int order() {
        return 1;
    }

    @Override
    public String execute(String input) {
        return "THREE_EXECUTED";
    }
}
