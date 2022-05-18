package com.mtms.exception.test;

/*******************************************************************************************************************************

-Description              :     TestAlreadyExistException is thrown when the test is already present.

*******************************************************************************************************************************/
public class TestAlreadyExistException extends RuntimeException{
	
private String resourceName;
	
	public TestAlreadyExistException(String resourceName) {
		super(resourceName); //Product not found with Id = 107
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
}
