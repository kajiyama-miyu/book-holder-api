package com.example.serivice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.LikeBooks;
import com.example.repository.LikeRepository;

@Service
@Transactional
public class LikeService {
	
	@Autowired
	private LikeRepository likeRepository;
	
	
	public void insertLikeBooks(LikeBooks likeBooks) {
		likeRepository.save(likeBooks);
	}
	

	public void deleteLikeBook (String bookId, String userId) {
		List<LikeBooks> likeList = likeRepository.findByBookIdAndUserId(bookId, userId);
		
		if(!likeList.isEmpty()) {
			likeRepository.delete(likeList.get(0));
		}
	}

}
