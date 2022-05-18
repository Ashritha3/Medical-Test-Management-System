package com.mtms.exception.center;

/*******************************************************************************************************************************

-Description              :     CenterNotFoundException class with getters, setters and constructor

*******************************************************************************************************************************/
public class CenterNotFoundException extends RuntimeException{
	
private String resourceName;
	
	public CenterNotFoundException(String resourceName) {
		super(resourceName); //Product not found with Id = 107
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

}