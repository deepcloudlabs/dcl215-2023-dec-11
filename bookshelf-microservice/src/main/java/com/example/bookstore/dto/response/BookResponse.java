package com.example.bookstore.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
	private String isbn;
	private String title;
	private int publicationYear;
}
