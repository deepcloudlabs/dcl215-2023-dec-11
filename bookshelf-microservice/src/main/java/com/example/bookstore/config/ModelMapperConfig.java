package com.example.bookstore.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.bookstore.domain.Book;
import com.example.bookstore.dto.request.AddBookRequest;

@Configuration
public class ModelMapperConfig {
	private final static Converter<AddBookRequest,Book> AddBookRequestToBook = context -> {
		var addBookRequest = context.getSource();
		return new Book(addBookRequest.getIsbn(), addBookRequest.getTitle(), addBookRequest.getPublicationYear());
	};
	
	@Bean
	public ModelMapper modelMapper() {
		var modelMapper = new ModelMapper();
		modelMapper.addConverter(AddBookRequestToBook, AddBookRequest.class,Book.class);
		return modelMapper;
	}
}
