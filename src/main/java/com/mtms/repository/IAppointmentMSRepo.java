package com.mtms.repository;

import java.math.BigInteger;
import java.time.LocalDateTime;

import org.springframework.data.repository.CrudRepository;

import com.mtms.model.Appointment;

/*******************************************************************************************************************************

-Description              :     AppointmentRepo interface acting as repository with Appointment class a type and BigInteger as ID

*******************************************************************************************************************************/

public interface IAppointmentMSRepo extends CrudRepository<Appointment, Integer> {

	public Appointment findByDateTimeAndTestId(LocalDateTime dateTime, Integer testId);

}