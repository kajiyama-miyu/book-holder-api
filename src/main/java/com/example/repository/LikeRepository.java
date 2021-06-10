package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.LikeBooks;

@Repository
public interface LikeRepository extends JpaRepository<LikeBooks, Integer>{

	List<LikeBooks> findByBookIdAndUserId(String bookId, String userId);
	
}
