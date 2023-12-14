package com.example.bookstore.config;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.modelmapper.ModelMapper;

import com.example.bookstore.domain.Book;
import com.example.bookstore.dto.request.AddBookRequest;

@DisplayName("ModelMapper Configuration Specification")
public class ModelMapperConfigSpecification {
	
	private static ModelMapper modelMapper;

	@BeforeAll
	static void init() {
		modelMapper = new  ModelMapperConfig().modelMapper();
	}
	
	@DisplayName("AddBookRequest --> Book")
	@ParameterizedTest
	@CsvSource({
		"1,Effective Java,2018",		
		"2,Elements of Reusable Software,1995"		
	})	
	void shouldMapAddBookRequestToBook(String isbn,String title,int publicationYear) {
		// 1. Test Fixture
		var addBookRequest = new AddBookRequest(isbn,title,publicationYear);
		// 2. Call exercise method
		var book = modelMapper.map(addBookRequest, Book.class);
		// 3. verification
		assertNotNull(book);
		assertAll(
			 () -> assertEquals(isbn, book.isbn()),
			 () -> assertEquals(title, book.title()),
			 () -> assertEquals(publicationYear, book.publicationYear())
		);		
	}
}
