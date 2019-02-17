package com.shopuser.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UserDataIncorrectException extends RuntimeException {
	
	public UserDataIncorrectException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

}
