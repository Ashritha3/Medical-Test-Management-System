package com.mtms.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtms.model.Appointment;
import com.mtms.model.AppointmentList;
import com.mtms.service.IAppointmentMSService;

/*******************************************************************************************************************************

-Description              :     AppointmentMSController Class for accessing Appointment Management System services

*******************************************************************************************************************************/

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class AppointmentMSController {

	@Autowired
	IAppointmentMSService service;

	@PostMapping("/makeappointment/{centerId}")
	public Appointment makeAppointment(@PathVariable Integer centerId,@RequestBody Appointment appointment) {
		return service.makeAppointment(centerId,appointment);
	}
	
	@GetMapping("/getappointment/{appointmentId}")
	public Appointment getAppointment(@PathVariable Integer appointmentId) {
		return service.getAppointment(appointmentId);
	}
	
	@GetMapping("/getallappointments")
	public AppointmentList getAllAppointment() {
		return service.getAllAppointments();
	}
	
	@DeleteMapping("/removeappointment/{appointmentId}")
	public boolean removeAppointment(@PathVariable Integer appointmentId)
	{
		return  service.removeAppointmentById(appointmentId);
	}
}