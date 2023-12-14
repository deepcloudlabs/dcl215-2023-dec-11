package com.example.bookstore.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddBookRequest {
	private String isbn;
	private String title;
	private int publicationYear;
	
}
