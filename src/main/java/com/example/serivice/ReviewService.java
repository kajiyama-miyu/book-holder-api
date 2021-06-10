package com.example.serivice;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Books;
import com.example.domain.Reviews;
import com.example.repository.BooksRepository;
import com.example.repository.ReviewRepository;

@Service
@Transactional
public class ReviewService {

	@Autowired
	private BooksRepository bookRepository;

	@Autowired
	private ReviewRepository reviewRepository;
	
	public void insertBook(Books book) {
		bookRepository.save(book);
	}
	
	public List<Books> getBooksByUserId(String userId) {
		List<Books> bookList = bookRepository.findByUserId(userId);
		
		if(bookList.isEmpty()) {
			return null;
		}
		
		return bookList;
	}
	
	public List<Books> getAllBooks() {
		List<Books> bookList = bookRepository.findAll();
		
		if(bookList.isEmpty()) {
			System.out.println("null!");
			return null;
		}
		
		
		return bookList;
	}
	
	
	public List<Books> getBookById (String bookId) {
		List<Books> bookList = bookRepository.findByBookId(bookId);
		
		if(bookList.isEmpty()) {			
			return null;
		}
		
		return bookList;
	}
	
	
	public Books getBooksByIdAndUserId(String bookId, String userId) {
		List<Books> bookList = bookRepository.findByBookIdAndUserId(bookId, userId);
		
		if(bookList.isEmpty()) {
			return null;
		}
		
		return bookList.get(0);
	}
	
	public void insertReview(Reviews reviews) {
		reviewRepository.save(reviews);
	}
	
	public void updateReview(Reviews reviews) {
		reviewRepository.save(reviews);
	}
	
	
	public Reviews getReviewByBookIdAndUserI (String bookId, String userId) {
		List<Reviews> reviews = reviewRepository.findByBookIdAndUserId(bookId, userId);
		
		if(reviews.isEmpty()) {
			return null;
		}
		
		return reviews.get(0);
	}
	
	public List<Reviews> getReviewByBookId(String bookId) {
		List<Reviews> reviews = reviewRepository.findByBookId(bookId);
		
		if(reviews.isEmpty()) {
			return null;
		}
		
		return reviews;
	}
	
	
	public void deleteReview (Integer reviewId) {
		reviewRepository.findById(reviewId).ifPresent(review -> reviewRepository.delete(review));
	}
	
	
	public void deleteBook (String bookId, String userId) {
		List<Books> book = bookRepository.findByBookIdAndUserId(bookId, userId);
		
		if(!book.isEmpty()) {
			bookRepository.delete(book.get(0));
		}
	}
	
}
