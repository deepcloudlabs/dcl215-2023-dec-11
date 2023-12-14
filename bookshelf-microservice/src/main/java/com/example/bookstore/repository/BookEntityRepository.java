package com.example.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore.entity.BookEntity;

public interface BookEntityRepository extends JpaRepository<BookEntity, String>{

}
