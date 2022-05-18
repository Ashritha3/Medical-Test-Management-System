package com.mtms.exception.register;

/*******************************************************************************************************************************

-Description              :     UserNameAlreadyExistException class to handle runtime exception

*******************************************************************************************************************************/

public class UserNameAlreadyExistException extends RuntimeException{

private String resourceName;
	
	public UserNameAlreadyExistException(String resourceName) {
		super(resourceName); //Product not found with Id = 107
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	
}