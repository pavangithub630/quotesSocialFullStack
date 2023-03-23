package com.pavan.quotesSocial.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserException extends RuntimeException {
	
	private String message;
}
