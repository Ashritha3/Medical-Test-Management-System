package com.mtms.service;

import java.util.List;

import com.mtms.model.DiagnosticCenter;
import com.mtms.model.DiagnosticTest;

/*******************************************************************************************************************************

-Description              :     DiagnosticTestService Interface with services for DiagnosticTest Management System

*******************************************************************************************************************************/
public interface IDiagnosticTestService {
	
    DiagnosticTest addTest(DiagnosticTest test);
    
	List<DiagnosticTest> getAllTests();
	
	DiagnosticTest getTestById(Integer testId);
	
	DiagnosticTest getTestByName(String testName);
	
	boolean removeAllTests();
	
//	boolean removeTest(String testName);
	
	boolean removeTestById(DiagnosticTest test);

}
