package com.pavan.quotesSocial.exceptions;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pavan.quotesSocial.Enitity.ResponseError;

import jakarta.servlet.http.HttpServletRequest;



@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(value =  UserException.class )
	ResponseEntity<ResponseError> userError(UserException userException, HttpServletRequest httpServletRequest) {
		ResponseError responseError = new ResponseError(userException.getMessage(), httpServletRequest.getRequestURI());
		return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value =  PostExeption.class )
	ResponseEntity<ResponseError> postError(PostExeption postExeption, HttpServletRequest httpServletRequest) {
		ResponseError responseError = new ResponseError(postExeption.getMessage(), httpServletRequest.getRequestURI());
		return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value =  LikesException.class )
	ResponseEntity<ResponseError> postError(LikesException likesException, HttpServletRequest httpServletRequest) {
		ResponseError responseError = new ResponseError(likesException.getMessage(), httpServletRequest.getRequestURI());
		return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
	}
	
	
	

	
}