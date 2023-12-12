package com.example;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.example.banking.util.MyMultiParameterProvider;
import com.example.banking.util.MyParameterProvider;
import com.example.banking.util.RandomNumberGeneratorUtility;

public class StudyParameterizedTest {

	@ParameterizedTest
	@ValueSource(ints= {4,8,15,16,23,42})
	void test1(int number) {
		System.err.println("Running the test with the number %d".formatted(number));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"ali", "jack", "veli", "kate", "zehra"})
	@NullAndEmptySource
	void test2(String name) {
		System.err.println("Running the test with the name %s".formatted(name));
	}
	
	@ParameterizedTest
	@CsvSource({
		"ankara,true,312", 
		"istanbul-anadolu,false,216", 
		"istanbul-avrupa,false,212"
	})
	void test3(String city,boolean isCapital,int areaCode) {
		System.err.println("%s,%s,%d".formatted(city,isCapital,areaCode));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = {"/area-codes.csv","/com/example/area-codes2.csv"})
	void test4(String city,boolean isCapital,int areaCode) {
		System.err.println("%s,%s,%d".formatted(city,isCapital,areaCode));
	}
	
	
	@ParameterizedTest
	@EnumSource(value = FiatCurrency.class)
	void test5(FiatCurrency currency) {
		System.err.println("%s,%d".formatted(currency.name(),currency.ordinal()));
	}
	
	@ParameterizedTest
	@MethodSource(value = {"generateSequence","generateRandomNumbers"})
	void test6(int number) {
		System.err.println("MethodSource using the value %d".formatted(number));
	}
	
	@ParameterizedTest
	@ArgumentsSource(MyParameterProvider.class)
	void test7(int number) {
		System.err.println("@ArgumentsSource using the value %d".formatted(number));
	}
	
	
	@ParameterizedTest
	@ArgumentsSource(MyMultiParameterProvider.class)
	void test8(String city,boolean isCapital,int areaCode) {
		System.err.println("%s,%s,%d".formatted(city,isCapital,areaCode));
	}
	
	static List<Integer> generateSequence(){
		return IntStream.range(1, 11).boxed().toList();
	}
	
	static List<Integer> generateRandomNumbers(){
		return RandomNumberGeneratorUtility.generate(10, 100, 20);
	}
}
