package com.mtms.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*******************************************************************************************************************************

-Description              :     DiagnosticCenter Bean Class

*******************************************************************************************************************************/
@Entity
@Table(name = "center_info")
public class DiagnosticCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "center_centerId_sequence")
	private Integer centerId;
	@Column
	private String centerName;

	@ManyToMany
	@JoinTable(name = "center_test", joinColumns = {
			@JoinColumn(name = "centerId", referencedColumnName = "centerId") }, inverseJoinColumns = {
					@JoinColumn(name = "testId", referencedColumnName = "testId") })
	@JsonIgnoreProperties("centerList")
	private List<DiagnosticTest> tests = new ArrayList();

	@OneToMany(mappedBy = "center") // , cascade = CascadeType.ALL)
	@JsonIgnoreProperties("center")
	private List<Appointment> appointment;

	public DiagnosticCenter() {
		super();
	}

	public DiagnosticCenter(Integer centerId, String centerName) {
		super();
		this.centerId = centerId;
		this.centerName = centerName;
	}

	public DiagnosticCenter(Integer centerId, String centerName, List<DiagnosticTest> tests,
			List<DiagnosticCenter> center, List<Appointment> appointment) {
		super();
		this.centerId = centerId;
		this.centerName = centerName;
		this.tests = tests;
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "DiagnosticCenter [centerId=" + centerId + ", centerName=" + centerName + ", tests=" + tests
				+ ", appointment=" + appointment + "]";
	}

	public Integer getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public List<DiagnosticTest> getTests() {
		return tests;
	}

	public void setTests(List<DiagnosticTest> tests) {
		this.tests = tests;
	}

	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

}