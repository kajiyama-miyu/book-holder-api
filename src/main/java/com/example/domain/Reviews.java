package com.example.domain;

import java.sql.Date;

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
@Table(name = "`reviews`")
public class Reviews {
	
	@Id
	@Column(name = "review_id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reviewId;
	
	@Column(name = "review", columnDefinition = "text")
	private String review;
	
	@Column(name = "read_date", columnDefinition = "date")
	private Date readDate;
	
	@Column(name = "star", columnDefinition = "integer")
	private Integer star;
	
	@Column(name = "book_id", columnDefinition = "text")
	private String bookId;
	
	@Column(name = "user_id", columnDefinition = "text")
	private String userId;
}
