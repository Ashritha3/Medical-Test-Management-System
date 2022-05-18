package com.mtms.exception.appointment;

/*******************************************************************************************************************************

-Description              :     AppointmentAlreadyApprovedException class to handle runtime exception

*******************************************************************************************************************************/

public class AppointmentAlreadyApprovedException extends RuntimeException {
	
	private String resourceName;

	public AppointmentAlreadyApprovedException(String resourceName) {
		super(resourceName); // Product not found with Id = 107
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

}