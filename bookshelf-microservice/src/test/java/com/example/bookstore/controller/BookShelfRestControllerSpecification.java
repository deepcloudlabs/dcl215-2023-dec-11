package com.example.bookstore.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.bookstore.dto.request.AddBookRequest;
import com.example.bookstore.dto.response.AddBookResponse;
import com.example.bookstore.dto.response.BookResponse;
import com.example.bookstore.dto.response.RemoveBookResponse;
import com.example.bookstore.service.BookShelfService;
import com.fasterxml.jackson.databind.ObjectMapper;

@DisplayName("Bookshelf Rest Api Specification")
@WebMvcTest(BookShelfRestController.class)
class BookShelfRestControllerSpecification {
	@Autowired
	private MockMvc mvc;
	@MockBean
	private BookShelfService bookShelfService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@DisplayName("Adding a Book to empty book shelf")
	@Test
	void shouldAddBookToEmptyBookShelf() throws Exception {
		// 1. Test Setup/Fixture
		   // @SpringBootTest
		   // @ExtendWith(SpringExtension.class)
		var addBookRequest = new AddBookRequest("1","Effective Java",2018);
		var bookAsJson = objectMapper.writeValueAsString(addBookRequest);
		   // mocking
		   Mockito.when(bookShelfService.addBook(addBookRequest))
		          .thenReturn(new AddBookResponse("1","Effective Java",2018));
		// 2. Call Exercise Method
		mvc.perform(MockMvcRequestBuilders.post("/books").content(bookAsJson).contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON))
		   .andDo(print())
		// 3. Verification
		   .andExpect(status().isOk())
		   .andExpect(MockMvcResultMatchers.jsonPath("$.isbn").exists())
		   .andExpect(MockMvcResultMatchers.jsonPath("$.title").isNotEmpty())
		   .andExpect(MockMvcResultMatchers.jsonPath("$.publicationYear").value(2018));
		// 4. Tear-down
	}

	@DisplayName("Removing a Book from non-empty book shelf")
	@Test
	void shouldRemoveBookFromNonEmptyBookShelf() throws Exception {
		// 1. Test Setup/Fixture
		   // mocking
		   Mockito.when(bookShelfService.removeBook("1"))
		          .thenReturn(new RemoveBookResponse("1","Effective Java",2018));
		// 2. Call Exercise Method
		mvc.perform(MockMvcRequestBuilders.delete("/books/1").accept(MediaType.APPLICATION_JSON))
		   .andDo(print())
		// 3. Verification
		   .andExpect(status().isOk())
		   .andExpect(MockMvcResultMatchers.jsonPath("$.isbn").exists())
		   .andExpect(MockMvcResultMatchers.jsonPath("$.title").isNotEmpty())
		   .andExpect(MockMvcResultMatchers.jsonPath("$.publicationYear").value(2018));
		// 4. Tear-down
		
	}
	@DisplayName("Asking a Book By Isbn from non-empty book shelf")
	@Test
	void shouldReturnBookByIsbnFromNonEmptyBookShelf() throws Exception {
		// 1. Test Setup/Fixture
		   // mocking
		   Mockito.when(bookShelfService.findBookByIsbn("1"))
		          .thenReturn(new BookResponse("1","Effective Java",2018));
		// 2. Call Exercise Method
		mvc.perform(MockMvcRequestBuilders.get("/books/1").accept(MediaType.APPLICATION_JSON))
		   .andDo(print())
		// 3. Verification
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.isbn").exists())
		.andExpect(MockMvcResultMatchers.jsonPath("$.title").isNotEmpty())
		.andExpect(MockMvcResultMatchers.jsonPath("$.publicationYear").value(2018));
		// 4. Tear-down
		
	}
}
