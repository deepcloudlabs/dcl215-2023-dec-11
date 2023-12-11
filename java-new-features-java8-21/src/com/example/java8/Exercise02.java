package com.example.java8;

import java.util.stream.IntStream;

public class Exercise02 {
	public static void main(String[] args) {
		Calculator calculator = new StandardCalculator();
		System.out.println(calculator.pow(2.0, 10));
	}
}

interface Calculator {
	double add(double x,double y);
	double sub(double x,double y);
	double mul(double x,double y);
	double div(double x,double y);
	// 1) public default method (Java SE 8)
	default double pow(double x,int y) {
		// return IntStream.range(0, y).mapToDouble(i -> x).reduce(1.0, this::mul);
		return IntStream.range(0, y).mapToDouble(i -> x).reduce(1.0, Calculator::multiply);
	}
	// 2) public static method -> functional programming, utility methods  (Java SE 8)
	static double multiply(double x,double y) {
		return x*y;
	}
	// 3) repeated codes in (1) -> private method (Java SE 9)
	// 4) repeated codes in (2) -> private static method (Java SE 9)
}

class StandardCalculator implements Calculator {

	@Override
	public double add(double x, double y) {
		return x+y;
	}

	@Override
	public double sub(double x, double y) {
		return x-y;
	}

	@Override
	public double mul(double x, double y) {
		return x*y;
	}

	@Override
	public double div(double x, double y) {
		return x/y;
	}
	
}