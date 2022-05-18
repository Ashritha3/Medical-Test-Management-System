package com.mtms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtms.exception.center.CenterNotFoundException;
import com.mtms.exception.register.UserNotFoundException;
import com.mtms.exception.test.ListisEmptyException;
import com.mtms.exception.test.TestAlreadyExistException;
import com.mtms.exception.test.TestNotFoundException;
import com.mtms.model.DiagnosticCenter;
import com.mtms.model.DiagnosticTest;
import com.mtms.repository.IDiagnosticCenterRepository;
import com.mtms.repository.IDiagnosticTestRepo;

/*******************************************************************************************************************************

-Description              :     DiagnosticTestServiceImpl Class implements services for DiagnosticTest Management System

*******************************************************************************************************************************/
@Service
public class DiagnosticTestServiceImpl implements IDiagnosticTestService {
	
	@Autowired
	private IDiagnosticTestRepo testRepo;
	
	@Autowired
	private IDiagnosticCenterService centerService;
  
	/*******************************************************************************************************************************
	-Function Name            :     addTest
	-Input Parameters         :     Test Object
	-Return Type              :     added test object
	-Throws                   :     TestNotFoundException,TestAlreadyExistException
	-Description              :     adding test to the database calls the method addTest(test)
	*******************************************************************************************************************************/
	@Override
	public DiagnosticTest addTest(DiagnosticTest test) {
		
		DiagnosticTest dtest=null;
		
		if(test == null) {
			throw new TestNotFoundException("Test is null");
		}
		
		List<DiagnosticTest> testList = testRepo.findBytestName(test.getTestName());
		if(testList.isEmpty()) {
			
		dtest = testRepo.save(test);
		}
		for(DiagnosticTest d:testList) {
			if(d.getTestName().equalsIgnoreCase(test.getTestName())) {
				throw new TestAlreadyExistException(test.getTestName()+" already exists");
			}
		}
		return dtest;
	}

	/*******************************************************************************************************************************
	-Function Name            :     getAllTests
	-Input Parameters         :     -
	-Return Type              :     List of tests
	-Throws                   :     ListEmptyException
	-Description              :     getting all tests from the database calls the method getAllTests()
	*******************************************************************************************************************************/
	@Override
	public List<DiagnosticTest> getAllTests() {
		
		List<DiagnosticTest> test = new ArrayList<DiagnosticTest>();
		Iterable<DiagnosticTest> it = testRepo.findAll();
		it.forEach((tests) -> {
			test.add(tests);
		});
		if(test.isEmpty()) {
			throw new ListisEmptyException("List is empty");
		}

		return test;
	}

	/*******************************************************************************************************************************
	-Function Name            :     getTestsById
	-Input Parameters         :     testId
	-Return Type              :     test object
	-Throws                   :     TestNotFoundException
	-Description              :     getting a test from the database calls the method getTestById(testId)
	*******************************************************************************************************************************/

	@Override
	public DiagnosticTest getTestById(Integer testId) {
		
		DiagnosticTest test = null;
		Optional<DiagnosticTest> opt = testRepo.findById(testId);
		if(opt.isEmpty()) {
			throw new TestNotFoundException("Test with Id "+testId+" is not found");
		}
		else {
			test = opt.get();
		}
		return test;
	}

	/*******************************************************************************************************************************
	-Function Name            :     removeAllTests
	-Input Parameters         :     -
	-Return Type              :     boolean
	-Throws                   :     -
	-Description              :     removing all tests from the database calls the method removeAllTests()
	*******************************************************************************************************************************/
	@Override
	public boolean removeAllTests() {
		
        testRepo.deleteAll();
		
		return true;
	}

	/*******************************************************************************************************************************
	-Function Name            :     getTestByName
	-Input Parameters         :     testName
	-Return Type              :     test object
	-Throws                   :     TestNotFoundException
	-Description              :     getting a test from the database calls the method getTestById(testId)
	*******************************************************************************************************************************/
	@Override
	public DiagnosticTest getTestByName(String testName) {
		
		DiagnosticTest test= null;
		List<DiagnosticTest> tList = testRepo.findBytestName(testName);
		for(DiagnosticTest d:tList) {
			if(d.getTestName().equalsIgnoreCase(testName)) {
				test = d;
			}
		}
		
		if(test == null) {
			throw new TestNotFoundException("Test with name"+testName+" is Not Found"); 
		}
		
	    return test;
	}
	
	/*******************************************************************************************************************************
    -Function Name            :     removeTestById
    -Input Parameters         :     Test Object
    -Return Type              :     boolean
    -Throws                   :     TestNotFoundException
    -Description              :     removing test to the database calls the method removeTest(test)
    *******************************************************************************************************************************/
	@Override
	public boolean removeTestById(DiagnosticTest test) {
		
		if (testRepo.findById(test.getTestId()).isEmpty()) {
			throw new TestNotFoundException("Test is not found");
		}
		testRepo.delete(test);
		System.out.println(!testRepo.existsById(test.getTestId()));
		return !testRepo.existsById(test.getTestId());
	}

}