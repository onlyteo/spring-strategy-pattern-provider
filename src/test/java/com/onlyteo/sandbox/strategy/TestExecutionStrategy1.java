package com.onlyteo.sandbox.strategy;

@Strategy
public class TestExecutionStrategy1 implements ExecutionStrategy<String, String> {

    @Override
    public boolean shouldExecute(String input) {
        return input != null && input.contains("ONE");
    }

    @Override
    public int order() {
        return 2;
    }

    @Override
    public String execute(String input) {
        return "ONE_EXECUTED";
    }
}
