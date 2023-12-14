package com.example.bookstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "isbn")
public class BookEntity {
	@Id	
	private String isbn;
	private String title;
	@Column(name="pubyear")
	private int publicationYear;
}
