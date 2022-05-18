package com.mtms.model;

import java.util.List;

public class DiagnosticTestList {

	private List<DiagnosticTest> testList;

	public DiagnosticTestList()
	{
		
	}
	
	public DiagnosticTestList(List<DiagnosticTest> testList) {
		super();
		this.testList = testList;
	}
	
	public List<DiagnosticTest> getTestList() {
		return testList;
	}
	public void setTestList(List<DiagnosticTest> testList) {
		this.testList = testList;
	}
	
	@Override
	public String toString() {
		return "DiagnosticTestList [testList=" + testList + "]";
	}
}
