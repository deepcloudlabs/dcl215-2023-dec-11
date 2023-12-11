package com.example.switch_features;

public class Exercise02 {

	public static void main(String[] args) {
		Animal animal = new Fish();
		var type = switch (animal) { // since java 21
		case Cat cat when cat.getLegs() > 0 -> {
			yield "Cat";
		}
		case Fish fish when fish.getLegs() > 0 -> {
			yield "Fish";			
		}
		case Spider spider when spider.getLegs() > 0 -> {
			yield "Spider";						
		}
		default -> {
			yield "Other Type of Animal";
		}
	  };
	  System.out.println(type);
	}
}

abstract class Animal { 
	private final int legs;

	public Animal(int legs) {this.legs = legs;}

	public int getLegs() {return legs;}
	
}
interface Pet {}
class Cat extends Animal implements Pet {
  public Cat() {super(4);}
}
class Fish extends Animal implements Pet {
	public Fish() {super(0);}	
}
class Spider extends Animal {
	public Spider() {super(8);}
}
