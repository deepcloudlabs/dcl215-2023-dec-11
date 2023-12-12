package com.example.banking.util;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class MyParameterProvider implements ArgumentsProvider{

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext ec) throws Exception {
		return ThreadLocalRandom.current().ints(10, 100).limit(10).sorted().boxed().map(Arguments::of);
	}

}
