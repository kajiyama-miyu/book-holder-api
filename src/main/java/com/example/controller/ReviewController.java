package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Books;
import com.example.domain.DeleteParams;
import com.example.domain.Reviews;
import com.example.domain.TotalReviewInfo;
import com.example.serivice.ReviewService;




@RestController
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	
	@GetMapping("books")
	public List<Books> getBookInfo(String userId) {
		return reviewService.getBooksByUserId(userId);
	}
	
	@GetMapping("all-books")
	public List<Books> getAllBooks () {
		return reviewService.getAllBooks();
	}
	
	@GetMapping("all-review/{bookId}")
	public TotalReviewInfo getAllReviewInfo (@PathVariable("bookId") String bookId) {
		List<Books> book = reviewService.getBookById(bookId);
		List<Reviews> review = reviewService.getReviewByBookId(bookId);
		
		TotalReviewInfo totalReviewInfo = new TotalReviewInfo();
		totalReviewInfo.setBooks(book);
		totalReviewInfo.setReviews(review);
		
		return totalReviewInfo;
	}
	
	@PutMapping("update")
	public void updateReview(@RequestBody Reviews reviews) {
		System.out.println("review="+reviews.getReview());
		reviewService.updateReview(reviews);
	}

	@PostMapping("post-book")
	@ResponseStatus(HttpStatus.CREATED)
	public void insertBook (@RequestBody Books book) {

		Books bookInfo = new Books();
		bookInfo.setBookId(book.getBookId());;
		bookInfo.setTitle(book.getTitle());
		bookInfo.setAuthor(book.getAuthor());
		bookInfo.setPrice(book.getPrice());
		bookInfo.setPublisher(book.getPublisher());
		bookInfo.setPublishedDate(book.getPublishedDate());
		bookInfo.setDescription(book.getDescription());
		bookInfo.setImage(book.getImage());
		bookInfo.setUserId(book.getUserId());
		
		reviewService.insertBook(bookInfo);
	}
	
	@PostMapping("post-review")
	@ResponseStatus(HttpStatus.CREATED)
	public void insertReview (@RequestBody Reviews review) {
		reviewService.insertReview(review);
	}
	
	
	@GetMapping("find-book/{bookId}")
	public List<Books> getBookByBookId (@PathVariable("bookId") String bookId) {
		System.out.println(reviewService.getBookById(bookId));
		return reviewService.getBookById(bookId);
		
	}
	
	@PostMapping("delete")
	public void DelteReview (@RequestBody DeleteParams deleteParams ) {
		reviewService.deleteReview(deleteParams.getReviewId());
		reviewService.deleteBook(deleteParams.getBookId(), deleteParams.getUserId());
	}
	
}
