package com.example.banking.util;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGeneratorUtility {
	public static List<Integer> generate(int min, int max, int size) {
		return ThreadLocalRandom.current().ints(min, max).limit(size).sorted().boxed().toList();
	}
}
