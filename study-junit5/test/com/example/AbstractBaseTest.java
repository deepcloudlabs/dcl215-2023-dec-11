package com.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class AbstractBaseTest {
	@BeforeAll
	static void initSpecification() {
		System.err.println("BeforeAll: Initializing specification...");
	}

	@AfterAll
	static void closeSpecification() {
		System.err.println("AfterAll: Closing specification...");
	}
}
