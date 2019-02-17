package com.shopuser.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/* @ResponseStatus permet de retourner le bon code HTTP à retourner, 
* ici c'est le code 404 sui sera retourner en cas d'absence de resultats
* 
* */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserIntrouvableException extends RuntimeException{ 
	
	
	public UserIntrouvableException(String message)
	{
		super(message);
	}

}
