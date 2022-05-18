package com.mtms.exception.register;

/*******************************************************************************************************************************

-Description              :     UserNotFoundException class to handle runtime exception

*******************************************************************************************************************************/

public class UserNotFoundException extends RuntimeException{

private String resourceName;
	
	public UserNotFoundException(String resourceName) {
		super(resourceName); //Product not found with Id = 107
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
}