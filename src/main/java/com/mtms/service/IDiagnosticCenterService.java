package com.mtms.service;

import java.math.BigInteger;

import com.mtms.model.DiagnosticCenter;
import com.mtms.model.DiagnosticCenterList;
import com.mtms.model.DiagnosticTest;

/*******************************************************************************************************************************
 
-Description              :     DiagnosticCenterService Interface with services for DiagnosticCenter Management System

*******************************************************************************************************************************/
public interface IDiagnosticCenterService {

	DiagnosticCenterList getAllCenters();

	DiagnosticCenter addCenter(DiagnosticCenter center);
	
	DiagnosticCenter getCenterById(Integer centerId);
	
	DiagnosticCenter getCenterByName(String centerName);
	
	DiagnosticCenter update(Integer centerId, DiagnosticCenter center);
    
	DiagnosticCenter assignTestId(Integer centerId,DiagnosticTest test);
	
//	DiagnosticCenter assignAppointmentId(Integer centerId,Integer appointmentId);
	
	boolean removeTestByName(Integer centerId,String test);
	
	boolean removeAllCenters();
	
	boolean removeCenter(DiagnosticCenter center);
}
