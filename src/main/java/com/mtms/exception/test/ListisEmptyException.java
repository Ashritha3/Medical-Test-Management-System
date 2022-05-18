package com.mtms.exception.test;

/*******************************************************************************************************************************

-Description              :     ListEmptyException is thrown when the list is empty.

*******************************************************************************************************************************/
public class ListisEmptyException extends RuntimeException{
	
private String resourceName;
	
	public ListisEmptyException(String resourceName) {
		super(resourceName); //Product not found with Id = 107
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

}