package com.example.bookstore.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.dto.request.AddBookRequest;
import com.example.bookstore.dto.response.AddBookResponse;
import com.example.bookstore.dto.response.BookResponse;
import com.example.bookstore.dto.response.RemoveBookResponse;
import com.example.bookstore.service.BookShelfService;

@RestController
@RequestMapping("/books")
public class BookShelfRestController {
	private final BookShelfService bookShelfService;
	
	public BookShelfRestController(BookShelfService bookShelfService) {
		this.bookShelfService = bookShelfService;
	}

	@PostMapping
	public AddBookResponse addBookToBookShelf(@RequestBody AddBookRequest request) {
		return bookShelfService.addBook(request);
	}
	
	@DeleteMapping("{isbn}")
	public RemoveBookResponse removeBookFromBookShelf(@PathVariable String isbn) {
		return bookShelfService.removeBook(isbn);
	}
	
	@GetMapping("{isbn}")
	public BookResponse findBookByIsbnFromBookShelf(@PathVariable String isbn) {
		return bookShelfService.findBookByIsbn(isbn);
	}
}
