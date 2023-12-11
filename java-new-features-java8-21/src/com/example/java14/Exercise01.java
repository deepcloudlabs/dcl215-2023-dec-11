package com.example.java14;

public class Exercise01 {

	public static void main(String[] args) {
		var point1 = new Point(1,2);
		System.out.println(point1);
		System.out.println(point1.x());
		System.out.println(point1.y());
		var color1 = new Color(5, 25, 125);
		var point2 = new ColorfulPoint(point1, color1);
		System.out.println(color1);
		System.out.println(point2);
		switch(point2) { // Java 21
		case ColorfulPoint (Point (double x,double y),Color(int red,int green,int blue)) 
		     when (red == 25 && x == 0) -> {
			
		}
		default -> {
			
		}
		}
	}

}

// immutable
record Point(double x,double y) {}
record Color(int red,int green,int blue) {}
record ColorfulPoint(Point p,Color c) {}

record A (B b) {}
record B (A a) {}