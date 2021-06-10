package com.example.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.Entity;


@Getter
@Setter
public class TotalReviewInfo {
	
	private List<Books> books;
	
	private List<Reviews> reviews;

}
