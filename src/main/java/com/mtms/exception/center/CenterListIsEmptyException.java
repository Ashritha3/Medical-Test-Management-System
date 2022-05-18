package com.mtms.exception.center;

/*******************************************************************************************************************************

-Description              :     CenterListIsEmptyException class with getters, setters and constructor

*******************************************************************************************************************************/

public class CenterListIsEmptyException extends RuntimeException{
	
private String resourceName;
	
	public CenterListIsEmptyException(String resourceName) {
		super(resourceName); //Product not found with Id = 107
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

}