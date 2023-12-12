package com.example;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class StudyDynamicTest {

	// Collection<DynamicTest>
	// Iterable<DynamicTest>
	// Iterator<DynamicTest>
	// Stream<DynamicTest>
	@TestFactory
	Collection<DynamicTest> test1(){		
		return List.of(
			dynamicTest(
				"dynamic test #1", 
				()->{
					System.err.println("Running dynamic test #1...");
					// 1. create test fixture/setup
					// 2. call exercise method
					// 3. verification
					// 4. tear-down
				}
			),	
			dynamicTest(
				"dynamic test #2", 
				()->{
					System.err.println("Running dynamic test #2...");
					// 1. create test fixture/setup
					// 2. call exercise method
					// 3. verification
					// 4. tear-down
				}
			)	
		);
	}
	@TestFactory
	Collection<DynamicTest> test2(){		
		return IntStream.range(0, 100)
				        .mapToObj(i -> dynamicTest(
				"dynamic test #%d".formatted(i), 
				()->{
					System.err.println("Running dynamic test #%d...".formatted(i));
					// 1. create test fixture/setup
					// 2. call exercise method
					// 3. verification
					// 4. tear-down
				}
			)).toList();
	}
	@TestFactory
	Stream<DynamicTest> test3(){		
		return IntStream.range(100, 200)
				.mapToObj(i -> dynamicTest(
						"dynamic test #%d".formatted(i), 
						()->{
							System.err.println("Running dynamic test #%d...".formatted(i));
							// 1. create test fixture/setup
							// 2. call exercise method
							// 3. verification
							// 4. tear-down
						}
				       )
				);
	}
	
	@TestFactory
	Stream<DynamicTest> test4(){		
		return List.of(4,8,15,16,23,42)
				.stream()
				.map(number -> dynamicTest(
						"dynamic test #%d".formatted(number), 
						()->{
							System.err.println("Running dynamic test #%d...".formatted(number));
							// 1. create test fixture/setup
							// 2. call exercise method
							// 3. verification
							// 4. tear-down
						}
				       )
				);
	}
	
	@TestFactory
	Stream<DynamicTest> test5(){		
		return List.of(
				"ankara,true,312", 
				"istanbul-anadolu,false,216", 
				"istanbul-avrupa,false,212"
				)
				.stream()
				.map(line -> dynamicTest(
						"dynamic test #%s".formatted(line), 
						()->{
							var tokens = line.split(",");
							System.err.println("Running dynamic test #%s...".formatted(tokens[0]));
							// 1. create test fixture/setup
							// 2. call exercise method
							// 3. verification
							// 4. tear-down
						}
				       )
				);
	}	
	@TestFactory
	Stream<DynamicTest> test6(){		
		return List.of(
				new AreaCode("ankara",true,312), 
				new AreaCode("istanbul-anadolu",false,216), 
				new AreaCode("istanbul-avrupa",false,212)
				)
				.stream()
				.map(areaCode -> dynamicTest(
						"dynamic test #%s".formatted(areaCode.city()), 
						()->{
							switch (areaCode) {
							case AreaCode(String city,boolean isCapital,int code) -> {
								System.err.println("Running dynamic test #%s...".formatted(city));
								// 1. create test fixture/setup
								// 2. call exercise method
								// 3. verification
								// 4. tear-down
							}					
						  }
						}
						)
						);
	}
	
	@SuppressWarnings("unused")
	@TestFactory
	Collection<DynamicTest> test7(){
		var protocols = List.of("https","http","ws","wss","sftp");
		var domainNames = List.of("server1.example.com","server2.example.com","server3.example.com");
		var ports = List.of(8080,7100,80,18080);
		var dynamicTests = new ArrayList<DynamicTest>();
		for (var domainName : domainNames ) {
			for (var port : ports) {				
				dynamicTests.add(dynamicTest("",()->{
					// use domain name and port
				}));
			}	
		}
		return dynamicTests; 
	}
}
