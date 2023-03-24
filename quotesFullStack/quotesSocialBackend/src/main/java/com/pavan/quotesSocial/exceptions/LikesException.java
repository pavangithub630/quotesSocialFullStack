package com.pavan.quotesSocial.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikesException extends RuntimeException {
	private String message;
	
}
