package com.onlyteo.sandbox.strategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import com.onlyteo.sandbox.strategy.ExecutionStrategy;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Strategy {

    @AliasFor("types")
    Class<? extends ExecutionStrategy>[] value() default {ExecutionStrategy.class};

    @AliasFor("value")
    Class<? extends ExecutionStrategy>[] types() default {ExecutionStrategy.class};
}
