package com.example.bookstore.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BookShelf {

	private final List<Book> books;

	public BookShelf() {
		this.books = new ArrayList<>();
	}

	public List<Book> getBooks() {
		return new CopyOnWriteArrayList<>(this.books);
	}

	public void addBook(Book book) {
		this.books.add(book);
	}

	public boolean searchBook(String bookTitle) {
		return books.stream().map(Book::title).anyMatch(bookTitle::equalsIgnoreCase);
	}

	public boolean removeBook(Book book) {
		return books.remove(book);
	}

}
