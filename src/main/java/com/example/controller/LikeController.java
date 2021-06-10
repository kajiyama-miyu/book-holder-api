package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.LikeBooks;
import com.example.serivice.LikeService;

@RestController
public class LikeController {
	
	@Autowired
	private LikeService likeService;
	
	
	@PostMapping("add_like")
	@ResponseStatus(HttpStatus.CREATED)
	public void insertLikeBook (@RequestBody LikeBooks likeBooks) {
		likeService.insertLikeBooks(likeBooks);
	}
	
	@GetMapping("delete_like")
	public void deleteLikeBook (String bookId, String userId) {
		likeService.deleteLikeBook(bookId, userId);
	}

}
