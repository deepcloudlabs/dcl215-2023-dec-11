package com.example.java8;

public class Exercise04 {
	public static void main(String[] args) {

	}
}

interface A {
	default public void fun() {
	}
}

interface B {
	default public void fun() {
	}
}

class P implements A, B {

	@Override
	public void fun() {
		B.super.fun();
	}
}