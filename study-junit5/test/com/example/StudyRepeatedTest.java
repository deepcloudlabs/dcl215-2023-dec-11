package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class StudyRepeatedTest {

	@RepeatedTest(value = 10, failureThreshold = 8, name="my repeatition test 1")
	public void test1(RepetitionInfo ri) {
		System.out.println("%d of %d test is running".formatted(ri.getCurrentRepetition(),ri.getTotalRepetitions()));
		System.out.println("%d of %d test has failed".formatted(ri.getFailureCount(),ri.getTotalRepetitions()));
		System.out.println("Test failure threshold is %d.".formatted(ri.getFailureThreshold()));
	    if (ri.getCurrentRepetition()%3 == 0) {
	    	assertTrue(false);
	    }
	}
}
