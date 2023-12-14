package com.example.bookstore.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Book Shelf Specification")
class BookShelfSpecification {
	private BookShelf bookShelf;

	
	@Nested
	@DisplayName("Empty Book Shelf")
	class EmptyBookShelf {
		
		@BeforeEach
		void createEmptyBookShelf() {
			bookShelf = new BookShelf();		
		}
		
		@Test
		void removingBookFromBookShelfWithNoBooks() {
			assertFalse(bookShelf.removeBook(new Book("4","Effective Java",2018)));
			var books = bookShelf.getBooks();
			assertEquals(0, books.size(),() -> "Book Shelf should be still empty even after one book is removed.");
		}

		@Test
		@DisplayName("with no books added yet")
		void emptyBookShelfWithNoBookAddedYet(TestInfo testInfo) {
			System.out.println("Working on the test case \"%s\"".formatted(testInfo.getDisplayName()));
			var books = bookShelf.getBooks();
			assertEquals(0, books.size(),() -> "Book Shelf should be empty when no books are added.");
		}
		
		@ParameterizedTest
		@CsvSource({
			"1,Elements of reusable software,1996", 
			"2,JUnit 5 in Action,2019", 
			"3,Domain-Driven Design,2003"
		})
		@DisplayName("with one book added")
		void emptyBookShelfWithOneBookAdded(String isbn,String title,int publicationYear,TestInfo testInfo) {
			System.out.println("Working on the test case \"%s\"".formatted(testInfo.getDisplayName()));
			bookShelf.addBook(new Book(isbn,title,publicationYear));
			var books = bookShelf.getBooks();
			assertEquals(1, books.size(),() -> "Book Shelf should have one book.");
			assertIterableEquals(books, List.of(new Book(isbn,title,publicationYear)));
		}
		
		@ParameterizedTest
		@ValueSource(strings = {
			"""			
			1,Elements of reusable software,1996 
			2,JUnit 5 in Action,2019 
			3,Domain-Driven Design,2003
			"""
		})
		@DisplayName("with multiple books added")
		void emptyBookShelfWithMultipleBooksAdded(String multipleBookLines,TestInfo testInfo) {
			System.out.println("Working on the test case \"%s\"".formatted(testInfo.getDisplayName()));
			var lines = multipleBookLines.split("\n");
			var toBeAddedBooks = Arrays.stream(lines)
			      .map(line -> line.split(","))
			      .map(tokens->new Book(tokens[0],tokens[1],Integer.parseInt(tokens[2])))
			      .toList();
			toBeAddedBooks.forEach(bookShelf::addBook);
			List<Book> books = bookShelf.getBooks();
			assertEquals(lines.length, books.size(),() -> "Book Shelf should have multiple books.");
			assertIterableEquals(books, toBeAddedBooks);
		}
	}

	@Nested
	@DisplayName("Searching Book Shelf With Multiple Books")
	class BookShelfWithMultipleBooks {
		
		@BeforeEach
		void createBookShelfWithMultipleBooks() {
			bookShelf = new BookShelf();
			List.of(
					new Book("1","Elements of reusable software",1996),
					new Book("2","JUnit 5 in Action",2019),
					new Book("3","Domain-Driven Design",2003)
				)
			    .stream()
			    .forEach(bookShelf::addBook);
		}
		
		@Test
		@DisplayName("Book Shelf with multiple books should ci search for existing book title")
		void ciSearchingBookOnBookShelfWithMultipleBooksShouldReturnTrue() {
			assertTrue(bookShelf.searchBook("junit 5 in ACTION"),()->"Book Shelf contains the book, so it should return true");
		}
		
		@Test
		@DisplayName("Book Shelf with multiple books should search for non-existing book title")
		void searchingBookOnBookShelfWithMultipleBooksShouldReturnFalse() {
			assertFalse(bookShelf.searchBook("Effective Java"),()->"Book Shelf does not contain the book, so it should return false");
		}
		
		@Test
		void removingBookFromBookShelfWithMultipleBooks() {
			var books = bookShelf.getBooks();
			var shelfSizeBeforeRemovingBook = books.size();
			assertTrue(bookShelf.removeBook(new Book("2","JUnit 5 in Action",2019)));
			books = bookShelf.getBooks();
			assertEquals(shelfSizeBeforeRemovingBook-1, books.size(),() -> "Book Shelf size should be one less then before removing the book.");
		}

	}
}
