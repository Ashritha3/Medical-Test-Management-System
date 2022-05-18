package com.mtms.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtms.exception.center.CenterListIsEmptyException;
import com.mtms.exception.center.CenterNameAlreadyExistException;
import com.mtms.exception.center.CenterNotFoundException;
import com.mtms.exception.register.UserNotFoundException;
import com.mtms.exception.test.ListisEmptyException;
import com.mtms.exception.test.TestAlreadyExistException;
import com.mtms.exception.test.TestNotFoundException;
import com.mtms.model.Appointment;
import com.mtms.model.DiagnosticCenter;
import com.mtms.model.DiagnosticCenterList;
import com.mtms.model.DiagnosticTest;
import com.mtms.repository.IDiagnosticCenterRepository;
import com.mtms.repository.IDiagnosticTestRepo;

/*******************************************************************************************************************************
 
-Description              :     DiagnosticCenterServiceImpl Class implements services for DiagnosticCenter Management System

*******************************************************************************************************************************/

@Service
public class DiagnosticCenterServiceImpl implements IDiagnosticCenterService {

	@Autowired
	private IDiagnosticCenterRepository centerRepo;

	@Autowired
	private IDiagnosticTestRepo testRepo;
	
	
	/*******************************************************************************************************************************
	-Function Name            :     getAllCenters
	-Input Parameters         :     No Input
	-Return Type              :     DiagnosticCenterList object
	-Throws                   :     CenterListIsEmptyException
	-Description              :     getting all centers present in the Center Database
	*******************************************************************************************************************************/
	
	@Override
	public DiagnosticCenterList getAllCenters() {

		List<DiagnosticCenter> center = new ArrayList<DiagnosticCenter>();
		Iterable<DiagnosticCenter> it = centerRepo.findAll();
		it.forEach((centers) -> {
			center.add(centers);
		});
		if (center.isEmpty()) {
			throw new CenterListIsEmptyException("List is empty");
		}

		return new DiagnosticCenterList(center);
	}

	/*******************************************************************************************************************************
	-Function Name            :     addCenter
	-Input Parameters         :     Center Object
	-Return Type              :     added Center object
	-Throws                   :     CenterNameAlreadyExistException(), CenterNameAlreadyExistException()
	-Description              :     adding Center to the Center Database Table using Spring Data
	*******************************************************************************************************************************/
	
	@Override
	public DiagnosticCenter addCenter(DiagnosticCenter center) {

		if (center == null) {
			throw new CenterNotFoundException("Center is empty");
		}
		List<DiagnosticCenter> cList = centerRepo.findByCenterName(center.getCenterName());
		for(DiagnosticCenter c:cList) {
		if(c.getCenterName().equalsIgnoreCase(c.getCenterName())) {
			throw new CenterNameAlreadyExistException("Center with name"+center.getCenterName()+"is already exists");
		}
		}
		return centerRepo.save(center);
	}
	
	/*******************************************************************************************************************************
	-Function Name            :     getCenterById
	-Input Parameters         :     centerId 
	-Return Type              :     DiagnosticCenter Object
	-Throws                   :     CenterNotFoundException
	-Description              :     getting Diagnostic Center based on centerId from Center DataBase Table
	*******************************************************************************************************************************/

	@Override
	public DiagnosticCenter getCenterById(Integer centerId) {

		DiagnosticCenter center = null;
		Optional<DiagnosticCenter> opt = centerRepo.findById(centerId);
		if (opt.isEmpty()) {
			throw new CenterNotFoundException("Center with Id " + centerId + " is not found");
		} else {
			center = opt.get();
		}
		System.out.println(center.getCenterName());
		return center;
	}

	/*******************************************************************************************************************************
	-Function Name            :     assignTestId
	-Input Parameters         :     centerId, testId
	-Return Type              :     updated DiagnosticCenter Object
	-Throws                   :     TestNotFoundException(),TestAlreadyExistException()
	-Description              :     adding testId Into tests Property of DiagnosticCenter of particular centerId
	*******************************************************************************************************************************/
	@Override
	public DiagnosticCenter assignTestId(Integer centerId, DiagnosticTest test) {

		DiagnosticTest testToAdd=null;
		if (test == null) {
			throw new TestNotFoundException("Test is empty");
		}
		DiagnosticCenter center = getCenterById(centerId);

		List<DiagnosticTest> testList = center.getTests();

		for (DiagnosticTest d : testList) {
			if (d.getTestName().equalsIgnoreCase(test.getTestName())) {
				throw new TestAlreadyExistException(test.getTestName() + " already exists in the center");
			}
		}

		List<DiagnosticTest> tList = testRepo.findBytestName(test.getTestName());
		
		System.out.println(tList);
		if(tList.isEmpty()) {
			throw new TestNotFoundException(test.getTestName()+"not found");
		}
		
		for (DiagnosticTest d : tList) {
			if (d.getTestName().equalsIgnoreCase(test.getTestName())) {
				testToAdd = d;
			}
		}
		
		testList.add(testToAdd);
	
		center.setTests(testList);
		
		return centerRepo.save(center);

	}

	/*******************************************************************************************************************************
	-Function Name            :     update
	-Input Parameters         :     centerId, center
	-Return Type              :     updated DiagnosticCenter Object
	-Throws                   :     CenterNotFoundException()
	-Description              :     updating of center object
	*******************************************************************************************************************************/
	@Override
	public DiagnosticCenter update(Integer centerId, DiagnosticCenter center) {
		
		if (centerRepo.findById(centerId).isEmpty()) {
			throw new CenterNotFoundException("Center is not found");
		}
		DiagnosticCenter dc = centerRepo.save(center);

		return dc;
	}
	
	/*******************************************************************************************************************************
	-Function Name            :     removeTestByName
	-Input Parameters         :     centerId, test
	-Return Type              :     boolean
	-Throws                   :     NoException
	-Description              :     removing test object from tests Property of DiagnosticCenter of particular centerId.
	*******************************************************************************************************************************/

	@Override
	public boolean removeTestByName(Integer centerId, String test) {

		System.out.println(test);
		DiagnosticCenter center = getCenterById(centerId);
		
		DiagnosticTest testNew = null;
		List<DiagnosticTest> testList = center.getTests();

		System.out.println(testList);
		for (DiagnosticTest t : testList) {
			if (t.getTestName().equalsIgnoreCase(test)) {
				testNew = t;
			}
		}
		testList.remove(testNew);
		center.setTests(testList);
		System.out.println(center.getTests());
		centerRepo.save(center);

		return true;

	}
	/*******************************************************************************************************************************
	-Function Name            :     removeAllCenters
	-Input Parameters         :     No Input
	-Return Type              :     boolean
	-Throws                   :     NoException
	-Description              :     removing all diagnosticCenters from Center Database.
	*******************************************************************************************************************************/
	@Override
	public boolean removeAllCenters() {

		centerRepo.deleteAll();

		return true;

	}

	/*******************************************************************************************************************************
	-Function Name            :     removeCenter
	-Input Parameters         :     Center Object
	-Return Type              :     boolean
	-Throws                   :     CenterNotFoundException
	-Description              :     removing Specified Center from Center DataBase Table.

	*******************************************************************************************************************************/
	@Override
	public boolean removeCenter(DiagnosticCenter center) {

		if (centerRepo.findById(center.getCenterId()).isEmpty()) {
			throw new CenterNotFoundException("Center is not found");
		}
		centerRepo.delete(center);
		return !centerRepo.existsById(center.getCenterId());

	}

	/*******************************************************************************************************************************
	-Function Name            :     getCenterByName
	-Input Parameters         :     centerName 
	-Return Type              :     DiagnosticCenter Object
	-Throws                   :     CenterNotFoundException
	-Description              :     getting Diagnostic Center based on center name from Center DataBase Table
	*******************************************************************************************************************************/	
	@Override
	public DiagnosticCenter getCenterByName(String centerName) {
		
		DiagnosticCenter center= null;
		List<DiagnosticCenter> cList = centerRepo.findByCenterName(centerName);
		for(DiagnosticCenter d:cList) {
			if(d.getCenterName().equalsIgnoreCase(centerName)) {
				center = d;
			}
		}
		
		if(center == null) {
			throw new CenterNotFoundException("Center with name"+centerName+" is Not Found"); 
		}
		
	    return center;
	}
	
	

}
