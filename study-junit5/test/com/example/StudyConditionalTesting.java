package com.example;

import org.junit.jupiter.api.Test;

import com.example.junit.ConditionalTestOnOperatingSystem;
import com.example.junit.OperatingSystemType;

public class StudyConditionalTesting {

	@Test
	@ConditionalTestOnOperatingSystem(OperatingSystemType.WINDOWS_11)
	@ConditionalTestOnOperatingSystem(OperatingSystemType.WINDOWS_10)
	void test1() {
		System.out.println("test1() is running...");
	}

	@Test
	@ConditionalTestOnOperatingSystem(OperatingSystemType.WINDOWS_10)
	@ConditionalTestOnOperatingSystem(OperatingSystemType.MAC_OS)
	void test2() {
		System.out.println("test2() is running...");
	}

	@Test
	@ConditionalTestOnOperatingSystem(OperatingSystemType.LINUX)
	void test3() {
		System.out.println("test3() is running...");
	}
}
