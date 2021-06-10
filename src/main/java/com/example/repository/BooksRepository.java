package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, String> {
	
	List<Books> findByUserId(String userId);
	List<Books> findByBookIdAndUserId(String bookId, String userId);
	List<Books> findByBookId(String bookId);
	

}
