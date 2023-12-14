package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Parallel Test")
public class StudyParallelTests {

	@Nested
	@DisplayName("Nested Test #1")
	class NestedTest1 {
		int counter = 0;
		@Test
		@DisplayName("test1")
		//@ResourceLock(value = "counter", mode = ResourceAccessMode.READ_WRITE)
		void test1(TestInfo testInfo) {
			System.err.println(
					"[%s] %s is running...".formatted(Thread.currentThread().getName(), testInfo.getDisplayName()));
			counter++;
		}

		@Test
		@DisplayName("test2")
		@ResourceLock(value = "counter", mode = ResourceAccessMode.READ)
		void test2(TestInfo testInfo) {
			System.err.println(
					"[%s] %s is running...".formatted(Thread.currentThread().getName(), testInfo.getDisplayName()));
			System.err.println("counter: %d".formatted(counter));
		}

	}

	@Nested
	@DisplayName("Nested Test #2")
	class NestedTest2 {
		int counter = 0;

		@Test
		@DisplayName("test3")
		void test3(TestInfo testInfo) {
			System.err.println(
					"[%s] %s is running...".formatted(Thread.currentThread().getName(), testInfo.getDisplayName()));
		}

		@Test
		@DisplayName("test4")
		void test4(TestInfo testInfo) {
			System.err.println(
					"[%s] %s is running...".formatted(Thread.currentThread().getName(), testInfo.getDisplayName()));
		}

		@Test
		@DisplayName("test10")
		void test10(TestInfo testInfo) {
			System.err.println(
					"[%s] %s is running...".formatted(Thread.currentThread().getName(), testInfo.getDisplayName()));
		}

		@ParameterizedTest
		@DisplayName("parameterized test")
		@ValueSource(ints = { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 })
		void test11(int number, TestInfo testInfo) {
			System.err.println("[%s][%d] %s is running...".formatted(Thread.currentThread().getName(), number,
					testInfo.getDisplayName()));
		}

		@RepeatedTest(10)
		@DisplayName("repetation test")
		@ResourceLock(value = "counter", mode = ResourceAccessMode.READ_WRITE)
		void test5(RepetitionInfo repetitionInfo, TestInfo testInfo) {
			System.err.println("[%s][%d][%d] %s is running...".formatted(Thread.currentThread().getName(),
					repetitionInfo.getCurrentRepetition(), repetitionInfo.getTotalRepetitions(),
					testInfo.getDisplayName()));
			counter++;
		}
	}
}
