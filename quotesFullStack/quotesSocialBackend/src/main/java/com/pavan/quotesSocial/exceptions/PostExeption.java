package com.pavan.quotesSocial.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostExeption extends RuntimeException {
	private String message;
}
