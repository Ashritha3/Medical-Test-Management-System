package com.mtms.exception.test;

/***************************************************************************************************************************************

-Description              :     TestNotFoundException is thrown when the admin tries to get the test that is not present in the database.

****************************************************************************************************************************************/

public class TestNotFoundException extends RuntimeException{
	
private String resourceName;
	
	public TestNotFoundException(String resourceName) {
		super(resourceName); //Product not found with Id = 107
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

}
