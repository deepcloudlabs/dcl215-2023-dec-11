package com.example.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore.entity.BookEntity;

public interface BookEntityRepository extends JpaRepository<BookEntity, String>{

	List<BookEntity> findAllByPublicationYear(int year);

	List<BookEntity> findAllByPublicationYearBetween(int beginYear, int endYear);

	List<BookEntity> findAllByTitleContaining(String title);

}
