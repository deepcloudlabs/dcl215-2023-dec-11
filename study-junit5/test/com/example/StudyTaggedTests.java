package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tagged Tests")
class StudyTaggedTests {

	@Test
	@UnitTest
	void test1() {
		
	}

	@Test
	@PerformanceTest
	@IntegrationTest
	void test2() {
		
	}
	@Test
	@FunctionalTest
	@PerformanceTest
	void test3() {
		
	}
	
	@Test
	@StressTest
	@PerformanceTest
	void test4() {
		
	}

}
