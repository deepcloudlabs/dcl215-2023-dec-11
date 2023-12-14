package com.example.bookstore.service.business;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookShelf;
import com.example.bookstore.dto.request.AddBookRequest;
import com.example.bookstore.dto.response.AddBookResponse;
import com.example.bookstore.dto.response.BookResponse;
import com.example.bookstore.dto.response.RemoveBookResponse;
import com.example.bookstore.service.BookShelfService;

@Service
public class StandardBookShelfService implements BookShelfService {
	private final BookShelf bookShelf;
	private final ModelMapper modelMapper;
	
	public StandardBookShelfService(BookShelf bookShelf, ModelMapper modelMapper) {
		this.bookShelf = bookShelf;
		this.modelMapper = modelMapper;
	}

	@Override
	@Transactional
	public AddBookResponse addBook(AddBookRequest request) {
		var book = modelMapper.map(request,Book.class);
		bookShelf.addBook(book);
		return modelMapper.map(book,AddBookResponse.class);
	}

	@Override
	@Transactional
	public RemoveBookResponse removeBook(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookResponse findBookByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

}
