package com.example.banking.util;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class MyMultiParameterProvider implements ArgumentsProvider{

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext ec) throws Exception {
		return Stream.of(Arguments.of("ankara",true,"312"),Arguments.of("istanbul-anadolu",false,"216"),Arguments.of("istanbul-avrupa",false,"212"));
	}

}
