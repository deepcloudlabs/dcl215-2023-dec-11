package com.example.junit;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.extension.ExtendWith;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Documented
@Inherited
@Repeatable(ConditionalTestOnOperatingSystems.class)
@ExtendWith(OperatingSystemCondition.class)
public @interface ConditionalTestOnOperatingSystem {
	OperatingSystemType value();	
}
