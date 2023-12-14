package com.example.bookstore.repository;

import javax.sql.DataSource;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

import com.example.bookstore.entity.BookEntity;

import jakarta.persistence.EntityManager;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;

@DisplayName("BookEntityRepository Specification")
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class BookEntityRepositorySpecification {
	@Autowired EntityManager entityManager;
	@Autowired JdbcTemplate jdbcTemplate;
	@Autowired JdbcClient jdbcClient;
	@Autowired DataSource dataSource;
	@Autowired BookEntityRepository bookEntityRepository;
	
	@Nested
	@DisplayName("Search Books")
	class QueryBooks {
		@BeforeEach
		void createBooks() throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
			var entity1 = new BookEntity("1","Effective Java",2018);
			var entity2 = new BookEntity("2","JUnit in Action",2014);
			var entity3 = new BookEntity("3","Elements of Reusable Software",1995);
			entityManager.persist(entity1);
			entityManager.persist(entity2);
			entityManager.persist(entity3);
			entityManager.flush();
		}
		
		@AfterEach
		void dropBooks() {
			var entity1 = new BookEntity("1","Effective Java",2018);
			var entity2 = new BookEntity("2","JUnit in Action",2014);
			var entity3 = new BookEntity("3","Elements of Reusable Software",1995);
			entityManager.remove(entity1);
			entityManager.remove(entity2);
			entityManager.remove(entity3);			
		}
		
		@Test
		@DisplayName("by publication year")
		void shouldSearchBookByPublicationYear() {
			
		}
		
	}
	
}
