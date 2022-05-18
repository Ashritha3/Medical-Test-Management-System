package com.mtms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*******************************************************************************************************************************

-Description              :     DiagnosticTest Bean class

*******************************************************************************************************************************/

@Entity
@Table(name = "test_info")
public class DiagnosticTest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="test_testId_sequence")
    private Integer testId;
	
	@Column
    private String testName;
	
	@ManyToMany(mappedBy="tests",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("tests")
	private List<DiagnosticCenter> centerList = new ArrayList();
	
	public DiagnosticTest(Integer testId, String testName, List<DiagnosticCenter> centerList) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.centerList = centerList;
	}

	public List<DiagnosticCenter> getCenterList() {
		return centerList;
	}

	public void setCenterList(List<DiagnosticCenter> centerList) {
		this.centerList = centerList;
	}

	public DiagnosticTest() {
		super();
	}
	

//	public DiagnosticTest(String testName, Integer testId) {
//		super();
//		this.testName = testName;
//		this.testId = testId;
//	}
	

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	@Override
	public String toString() {
		return "DiagnosticTest [testName=" + testName + ", testId=" + testId + "]";
	}

}