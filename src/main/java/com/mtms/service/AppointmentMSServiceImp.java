package com.mtms.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtms.exception.appointment.AppointmentAlreadyApprovedException;
import com.mtms.exception.appointment.AppointmentNotFoundException;
import com.mtms.exception.appointment.SlotNotAvailableException;
import com.mtms.exception.test.ListisEmptyException;
import com.mtms.model.Appointment;
import com.mtms.model.AppointmentList;
import com.mtms.model.DiagnosticCenter;
import com.mtms.repository.IAppointmentMSRepo;

/*******************************************************************************************************************************

-Description              :     AppointmentMSServiceImp Class implements services for Appointment Management System

*******************************************************************************************************************************/

@Service
public class AppointmentMSServiceImp implements IAppointmentMSService {

	@Autowired
	IAppointmentMSRepo appointmentRepo;
	
	@Autowired
    IDiagnosticCenterService centerService;
	
	/*******************************************************************************************************************************
	-Function Name            :     makeAppointment
	-Input Parameters         :     centerId,Appointment Object
	-Return Type              :     appointment object
	-Throws                   :     SlotNotAvailableException
	-Description              :     making appointment to the particular center
	*******************************************************************************************************************************/
	
	@Override
	public Appointment makeAppointment(Integer centerId,Appointment appointment) {
		
		DiagnosticCenter center = centerService.getCenterById(centerId);

		List<Appointment> appList = center.getAppointment();
		
		LocalTime time = appointment.getDateTime().toLocalTime();

		if ((appointmentRepo.findByDateTimeAndTestId(appointment.getDateTime(), appointment.getTestId()) != null)
				|| appointment.getDateTime().isBefore(LocalDateTime.now().plusHours(1))
				|| appointment.getDateTime().isAfter(LocalDateTime.now().plusMonths(3))
				|| time.isBefore(LocalTime.of(6, 59)) || time.isAfter(LocalTime.of(21, 00))) {
			throw new SlotNotAvailableException("This slot is not available");
		}
		
		appointment.setCenter(center);
		
		Appointment app = appointmentRepo.save(appointment);
		
		appList.add(getAppointment(app.getAppointmentId()));
		

		return app;
	}
	
	/*******************************************************************************************************************************
	-Function Name            :     getAppointment
	-Input Parameters         :     appointmentId 
	-Return Type              :     Appointment Object
	-Throws                   :     AppointmentNotFoundException
	-Description              :     getting appointment based on appointmentId from appointment database table
	*******************************************************************************************************************************/
	
	@Override
	public Appointment getAppointment(Integer appointmentId) {

		Appointment app = null;
		Optional<Appointment> opt = appointmentRepo.findById(appointmentId);
		if (opt.isPresent() == false) {

			throw new AppointmentNotFoundException("Appointment with Id " + appointmentId + " is not found");
		} else {
			app = opt.get();
		}
		System.out.println(app.getUserId());
		return app;

	}

	/*******************************************************************************************************************************
	-Function Name            :     getAllAppointments
	-Input Parameters         :     -
	-Return Type              :     appointment list
	-Throws                   :     AppointmentNotFoundException
	-Description              :     getting all the appointments from the appointment database table 
	*******************************************************************************************************************************/
	
	@Override
	public AppointmentList getAllAppointments() {

		List<Appointment> appointments = new ArrayList<Appointment>();
		Iterable<Appointment> it = appointmentRepo.findAll();
		if(it==null) {
			throw new AppointmentNotFoundException("Appointments are not available");
		}
		it.forEach((app) -> {
			appointments.add(app);
		});
		

		return new AppointmentList(appointments);
	}

	/*******************************************************************************************************************************
	-Function Name            :     approveAppointment
	-Input Parameters         :     Appointment Object and status boolean variable 
	-Return Type              :     appointment object
	-Throws                   :     AppointmentAlreadyApprovedException
	-Description              :     approves appointment and updates the appointment present in appointment database table 
	*******************************************************************************************************************************/
	
	@Override
	public Appointment approveAppointment(Appointment appointment, boolean status) {
		if(appointment.isApproved()) {
			throw new AppointmentAlreadyApprovedException(
					"Appointment with Id :" + appointment.getAppointmentId() + " is Already Approved");
		}

		appointment.setApproved(status);
		return appointmentRepo.save(appointment);
	}

	/*******************************************************************************************************************************
	-Function Name            :     removeAppointmentById
	-Input Parameters         :     appointmentId  
	-Return Type              :     boolean status
	-Throws                   :     AppointmentAlreadyApprovedException
	-Description              :     deletes appointment that is stored under listOfAppointments
	*******************************************************************************************************************************/
	@Override
	public boolean removeAppointmentById(Integer appointmentId) {
		if(!appointmentRepo.existsById(appointmentId)) {
    		throw new AppointmentNotFoundException("Appointment with id: "+appointmentId+" not found");
    	}

		appointmentRepo.deleteById(appointmentId);
		return true;
	}

	/*******************************************************************************************************************************
	-Function Name            :     getAppointmentBycId
	-Input Parameters         :     centerId 
	-Return Type              :     AppointmentList
	-Throws                   :     ListisEmptyException
	-Description              :     getting appointmentlist based on centerId from appointment database table
	*******************************************************************************************************************************/
	@Override
	public AppointmentList getAppointmentBycId(Integer centerId) {
		
		List<Appointment> appointments = new ArrayList<Appointment>();
		Iterable<Appointment> it = appointmentRepo.findAll();
		if(it==null) {
			throw new ListisEmptyException("Appointments are not available");
		}

		for(Appointment app:it) {
			if(app.getCenter().getCenterId() == centerId) {
				appointments.add(app);
			}
		}
		return new AppointmentList(appointments);
	
	}

}