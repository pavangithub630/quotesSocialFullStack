package com.pavan.quotesSocial.Enitity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;
	
	private LocalDate date;
	
	private LocalTime time;
	
	private  LocalDateTime localDateTime;
	
	private String quote;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false,referencedColumnName = "userId")
	@JsonBackReference(value="userposts")
	private User user;
	
	@JsonManagedReference(value = "postlikes")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "post")
	private List<Likes> likes;

	
	
	
	
}
