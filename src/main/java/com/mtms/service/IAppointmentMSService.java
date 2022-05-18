package com.mtms.service;

import java.math.BigInteger;

import com.mtms.model.Appointment;
import com.mtms.model.AppointmentList;

/*******************************************************************************************************************************

-Description              :     IAppointmentMSService Interface with services for Appointment Management System

*******************************************************************************************************************************/
public interface IAppointmentMSService {

	Appointment makeAppointment(Integer centerId,Appointment appointment);

	Appointment getAppointment(Integer appointmentId);

	AppointmentList getAllAppointments();
	
	AppointmentList getAppointmentBycId(Integer centerId);

	Appointment approveAppointment(Appointment appointment, boolean status);

	boolean removeAppointmentById(Integer appointmentId);

}