package com.mtms.exception.center;

/*******************************************************************************************************************************

-Description              :     CenterNameAlreadyExistException class with getters, setters and constructor

*******************************************************************************************************************************/
public class CenterNameAlreadyExistException extends RuntimeException{
	
private String resourceName;
	
	public CenterNameAlreadyExistException(String resourceName) {
		super(resourceName); //Product not found with Id = 107
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

}