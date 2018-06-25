package com.onlyteo.sandbox.strategy;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = {TestSpringConfig.class})
@ExtendWith({SpringExtension.class})
class OrderedExecutionStrategyTest {

    @Autowired
    private TestOrderedExecutionStrategyProvider strategyProvider;

    @Test
    void name() {
        List<String> result = strategyProvider.execute("ONE, TWO, THREE");

        assertThat(result).containsExactly("THREE_EXECUTED", "ONE_EXECUTED", "TWO_EXECUTED");
    }
}
