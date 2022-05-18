package com.mtms.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*******************************************************************************************************************************

-Description              :     Appointment Bean Class

*******************************************************************************************************************************/

@Entity
@Table(name = "appointment_info")
public class Appointment {

	@Column
	private Integer userId;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "appointment_appointmentId_sequence")
	private Integer appointmentId;
	@Column
	private Integer testId;
	@Column
//	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm")
	private LocalDateTime dateTime;
	@Column
	private boolean approved = false;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CenterId")
	@JsonIgnoreProperties({"appointment","tests"})
	private DiagnosticCenter center;

	public DiagnosticCenter getCenter() {
		return center;
	}

	public void setCenter(DiagnosticCenter center) {
		this.center = center;
	}

	public Appointment(Integer userId, Integer appointmentId, Integer testId, LocalDateTime dateTime,
			boolean approved) {
		super();
		this.userId = userId;
		this.appointmentId = appointmentId;
		this.testId = testId;
		this.dateTime = dateTime;
		this.approved = approved;
	}

	public Appointment() {
		super();

	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	@Override
	public String toString() {
		return "Appointment [userId=" + userId + ", appointmentId=" + appointmentId + ", testId=" + testId
				+ ", dateTime=" + dateTime + ", approved=" + approved + ", center=" + center + "]";
	}

}