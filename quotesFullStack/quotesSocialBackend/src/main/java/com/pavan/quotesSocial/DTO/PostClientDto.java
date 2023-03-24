package com.pavan.quotesSocial.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostClientDto {
	
	private Long postId;
	
	private LocalDate date;
	
	private LocalTime time;
	
	private String quote;
	
	private boolean liked;

}
