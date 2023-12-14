package com.example.bookstore.service.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookShelf;
import com.example.bookstore.dto.request.AddBookRequest;
import com.example.bookstore.dto.response.AddBookResponse;

@DisplayName("StandardBookShelfService Specification")
public class StandardBookShelfServiceSpecification {
    StandardBookShelfService bookShelfService;
    ModelMapper modelMapper;
    BookShelf bookShelf;
	
    @BeforeEach
    void init() {
    	bookShelf = Mockito.mock(BookShelf.class);
    	modelMapper = Mockito.mock(ModelMapper.class);
    	bookShelfService = new StandardBookShelfService(bookShelf, modelMapper);
    }
    
	@DisplayName("Add new Book to the Book Shelf")
	@ParameterizedTest
	@CsvSource({
		"1,Effective Java,2018",		
		"2,Elements of Reusable Software,1995"		
	})
	void shouldAddNewBookToBookShelf(String isbn,String title,int publicationYear) {
		//1. Test Setup/Fixture
		var addBookRequest = new AddBookRequest(isbn,title,publicationYear);
	    Book book = new Book(isbn,title,publicationYear);
	    Mockito.when(modelMapper.map(addBookRequest,Book.class))
               .thenReturn(book);	    
	    Mockito.when(modelMapper.map(book,AddBookResponse.class))
	           .thenReturn(new AddBookResponse(isbn,title,publicationYear));		
	    Mockito.doNothing().when(bookShelf).addBook(book);		
		//2. Call Exercise Method
		var addBookResponse = bookShelfService.addBook(addBookRequest);
		//3. Verification
		assertEquals(isbn,addBookResponse.getIsbn());
		assertEquals(title,addBookResponse.getTitle());
		assertEquals(publicationYear,addBookResponse.getPublicationYear());
	}
}
