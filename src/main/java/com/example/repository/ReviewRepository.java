package com.example.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Reviews;

@Repository

public interface ReviewRepository extends JpaRepository<Reviews, Integer> {

	List<Reviews> findByBookIdAndUserId(String bookId, String userId);
	List<Reviews> findByReviewId(Integer reviewId);
	List<Reviews> findByBookId(String bookId);
	

}
