package com.example.bookstore.service;

import com.example.bookstore.dto.request.AddBookRequest;
import com.example.bookstore.dto.response.AddBookResponse;
import com.example.bookstore.dto.response.BookResponse;
import com.example.bookstore.dto.response.RemoveBookResponse;

public interface BookShelfService {

	AddBookResponse addBook(AddBookRequest request);

	RemoveBookResponse removeBook(String isbn);

	BookResponse findBookByIsbn(String isbn);

}
