package com.onlyteo.sandbox.strategy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = {TestSpringConfig.class})
@ExtendWith({SpringExtension.class})
class SingleExecutionStrategyTest {

    @Autowired
    private TestSingleExecutionStrategyProvider strategyProvider;

    @Test
    void name() {
        String result = strategyProvider.execute("TWO");

        assertThat(result).isEqualTo("TWO_EXECUTED");
    }
}
