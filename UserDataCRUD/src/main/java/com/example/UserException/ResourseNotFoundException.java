package com.example.UserException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Source not Found")
public class ResourseNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourseNotFoundException(String message) {
		super(message);
	}

}
