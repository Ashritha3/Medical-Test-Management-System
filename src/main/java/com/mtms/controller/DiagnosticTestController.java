package com.mtms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtms.model.DiagnosticCenter;
import com.mtms.model.DiagnosticTest;
import com.mtms.model.DiagnosticTestList;
import com.mtms.service.DiagnosticTestServiceImpl;

/*******************************************************************************************************************************

-Description              :     DiagnosticTestController Class for accessing DiagnosticTest Management System services

*******************************************************************************************************************************/
@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
public class DiagnosticTestController {

	@Autowired
	DiagnosticTestServiceImpl service;
	
	@GetMapping("/getalltests")
	public DiagnosticTestList getAllTests(){
		return new DiagnosticTestList(service.getAllTests());
	}
	@GetMapping("/gettest/test-id/{testId}")
	public DiagnosticTest getTest(@PathVariable Integer testId){
		return service.getTestById(testId);
	}
	@PostMapping("/addtest")
	public DiagnosticTest addTest(@RequestBody DiagnosticTest test) {
		return service.addTest(test);
	}
	
	@GetMapping("/gettest/{testName}")
	public DiagnosticTest getTestByName(@PathVariable String testName){
		return service.getTestByName(testName);
	}
	
	@DeleteMapping("/removetest/by-id/{testId}")
	public boolean removeTest(@PathVariable Integer testId) {
		return service.removeTestById(getTest(testId));
	}
	
//	@DeleteMapping("/removetest/{testName}")
//	public boolean removeTest(@PathVariable String testName) {
//		return service.removeTest(testName);
//	}
	
	@DeleteMapping("/removealltests")
	public String removeAllTests() {
		service.removeAllTests();
		return "All Test Removed";
	}
}