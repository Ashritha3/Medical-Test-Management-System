package com.mtms.exception.appointment;

/*******************************************************************************************************************************

-Description              :     SlotNotAvailable class to handle runtime exception

*******************************************************************************************************************************/

public class SlotNotAvailableException  extends RuntimeException{
	
	private String resourceName;

	public SlotNotAvailableException(String resourceName) {
		super(resourceName); // Product not found with Id = 107
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

}