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
@Getter
@Setter
@Table(name = "`users`")
public class Users {
	
	@Id
	@Column(name = "id", columnDefinition = "serial")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "email", columnDefinition = "text")
	private String email;
	
	@Column(name = "password", columnDefinition = "text")
	private String password;
	
	@Column(name = "auth", columnDefinition = "auth")
	private String auth;

}
