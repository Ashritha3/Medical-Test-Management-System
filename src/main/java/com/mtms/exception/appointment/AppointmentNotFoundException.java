package com.mtms.exception.appointment;

/*******************************************************************************************************************************

-Description              :     AppointmentNotFoundException class to handle runtime exception

*******************************************************************************************************************************/

public class AppointmentNotFoundException  extends RuntimeException {
	
	private String resourceName;

	public AppointmentNotFoundException(String resourceName) {
		super(resourceName); // Product not found with Id = 107
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

}