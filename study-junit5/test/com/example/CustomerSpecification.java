package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName("a customer")
@TestMethodOrder(value = MethodOrderer.MethodName.class)
public class CustomerSpecification extends AbstractBaseTest {

	@BeforeEach
	public void createFixture() {
		System.err.println("BeforeEach: Creating fixture...");
	}

	@AfterEach
	public void destroyFixture() {
		System.err.println("AfterEach: Destroying fixture...");
	}

	@Test
	@Order(3)
	@DisplayName("ikinci")
	void test2() {
		System.err.println("test2() is running...");
		assertTrue(true);
	}

	@DisplayName("ilk")
	@Test
	@Order(2)
	void test1() {
		System.err.println("test1() is running...");

	}


	@Test
	@Order(1)
	@DisplayName("ucuncu")
	void test3() {
		System.err.println("test3() is running...");
		assertTrue(true);
	}

}
