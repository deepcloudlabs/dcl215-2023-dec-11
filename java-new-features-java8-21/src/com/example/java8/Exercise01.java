package com.example.java8;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class Exercise01 {

	public static void main(String[] args) {
		// Functional Programming
		// Higher-Order Function: filter/map/reduce
		//    function -> Abstract Data Type -> functional interface -> SAM
		// Pure Function -> side-effect free functions
		//    i) Lambda Expression
		//   ii) Method Reference: a) object's method b) static method
		Employee employee; // reference variable
		employee = new Employee(); // references to an object
		PreciousService service = new PreciousService();
		Fun fun1; // reference variable
		fun1 = service::doCommand; // references to a function
		int z = 42; // stack, effectively final
		// z++;
		Fun fun2; // reference variable
		// fun2 = (x,y) -> x+y*y+ ++z; // it is NOT pure anymore!
		fun2 = (x,y) -> x+y*y+z;
		Supplier<G> fun3 = () -> new G(); 
		Supplier<G> fun4 = G::new; 
	}

}
class G {}
class Employee {
	
}
class PreciousService {
	int doCommand(int x,int y) {
		return x+y*y;
	}	
}
@FunctionalInterface
interface Fun { // Single Abstract Method
	int fun(int x,int y);
	
}
