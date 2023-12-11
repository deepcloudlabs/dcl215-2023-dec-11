package com.example.switch_features;

public class Exercise01 {

	public static void main(String[] args) {
		String weekDay = "monday"; // since Java SE 7
		var message = 
		switch (weekDay) {
		case "monday", "tuesday", "wednesday", "thursday", "friday" -> {
			yield "Work Hard!";
		}
		case "saturday", "sunday" -> {
			yield "Rest now!";
		}
		default -> {
			yield "This is not a valid week day!";
		}
		};
		System.out.println(message);

	}

}
