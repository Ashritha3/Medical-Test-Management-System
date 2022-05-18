package com.mtms.exception.register;

/*******************************************************************************************************************************

-Description              :     EmailAlreadyExistException class to handle runtime exception

*******************************************************************************************************************************/

public class EmailAlreadyExistException extends RuntimeException{

private String resourceName;
	
	public EmailAlreadyExistException(String resourceName) {
		super(resourceName); //Product not found with Id = 107
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
}