package com.example.bookstore.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemoveBookResponse {
	private String isbn;
	private String title;
	private int publicationYear;
}
