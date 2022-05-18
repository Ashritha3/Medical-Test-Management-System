package com.mtms.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtms.model.Appointment;
import com.mtms.model.AppointmentList;
import com.mtms.service.IAppointmentMSService;

/*******************************************************************************************************************************

-Description              :     ApproveAppointmentController Class for accessing Appointment Management System services

*******************************************************************************************************************************/

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/admin")
public class ApproveAppointmentController {

	@Autowired
	IAppointmentMSService service;

	@GetMapping("/getAppointment/{appointmentId}")
	public Appointment getAppointment(@PathVariable Integer appointmentId) {
		return service.getAppointment(appointmentId);
	}

	@GetMapping("/getallappointments")
	public AppointmentList getAllAppointment() {
		return service.getAllAppointments();
	}
	
	@GetMapping("/getallappointments/{centerId}")
	public AppointmentList getAppointmentBycId(@PathVariable Integer centerId) {
		return service.getAllAppointments();
	}
	

	@PutMapping("/approveAppointment/{appointmentId}/{status}")
	public Appointment approveAppoinment(@PathVariable Integer appointmentId, @PathVariable boolean status) {
		Appointment appointment = service.getAppointment(appointmentId);
		return service.approveAppointment(appointment, status);
	}
}
