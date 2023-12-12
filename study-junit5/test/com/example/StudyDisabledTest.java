package com.example;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


// Ctrl+Shift+O: Organize Import
@Disabled("will be implemented in the next sprint")
public class StudyDisabledTest {

	@DisplayName("My Test A")
	@Test
	public void test1() {
		assertTrue(false);	
	}

	@DisplayName("My Test B")
	@Test
	public void test2() {
		
	}	
}
