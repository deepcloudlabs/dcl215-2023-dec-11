package com.example.java10;

import java.util.List;

@SuppressWarnings("unused")
public class Exercise01 {

	public static void main(String[] args) {
		var x = 42; // int
		var y = 42.0; // double
		List<Integer> numbers = List.of(3, 2, 5, 6);
		var ints = List.of(3, 2, 5, 6); // List<Integer>
		// Integer, Double, String
		// JLS
		List<Integer> z = List.of(3, 2, 5); // List<Object & Serializable>
	    
	}

}