package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "`like_books`")
public class LikeBooks {

	@Id
	@Column(name = "like_id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer LikeId;
	
	
	@Column(name = "title", columnDefinition = "text")
	private String title;
	
	
	@Column(name = "author", columnDefinition = "text")
	private String author;
	
	@Column(name = "price", columnDefinition = "text")
	private String price;
	
	@Column(name = "publisher", columnDefinition = "text")
	private String publisher;
	
	@Column(name = "published_date", columnDefinition = "text")
	private String  publishedDate;
	
	@Column(name = "description", columnDefinition = "text")
	private String description;
	
	@Column(name = "image", columnDefinition = "text")
	private String image;
	
	@Column(name = "book_id", columnDefinition = "text")
	private String bookId;
	
	@Column(name = "user_id", columnDefinition = "text")
	private String userId;
}
