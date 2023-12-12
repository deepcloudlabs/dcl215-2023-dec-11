package com.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BeforeAndAfterAnnotationsUnitTest {
	static String input;
	static Long result;

	@BeforeAll
	static void setup() {
		input = "77";
	}

	@AfterAll
	static void teardown() {
		input = null;
		result = null;
	}
	
	@BeforeEach
	void fun() {}
	@AfterEach
	void gun() {}
	
	@Test
	void whenConvertStringToLongThenResultShouldBeLong() {
		result = Long.valueOf(input);
		Assertions.assertEquals(77l, result);
	}
}
