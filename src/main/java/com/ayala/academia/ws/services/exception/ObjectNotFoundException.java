package com.ayala.academia.ws.services.exception;

import java.io.Serializable;

public class ObjectNotFoundException extends RuntimeException implements Serializable{
	
	public ObjectNotFoundException(String message) {
		super(message);
	}

}
