package com.mtms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mtms.exception.appointment.AppointmentAlreadyApprovedException;
import com.mtms.exception.appointment.AppointmentNotFoundException;
import com.mtms.exception.appointment.SlotNotAvailableException;
import com.mtms.exception.center.CenterListIsEmptyException;
import com.mtms.exception.center.CenterNameAlreadyExistException;
import com.mtms.exception.center.CenterNotFoundException;
import com.mtms.exception.register.ContactNumberAlreadyExistException;
import com.mtms.exception.register.EmailAlreadyExistException;
import com.mtms.exception.register.UserNameAlreadyExistException;
import com.mtms.exception.register.UserNotFoundException;
import com.mtms.exception.test.ListisEmptyException;
import com.mtms.exception.test.TestAlreadyExistException;
import com.mtms.exception.test.TestNotFoundException;

/*******************************************************************************************************************************

-Description              :     ErrorHandler Class for handling Medical Management System Exceptions

*******************************************************************************************************************************/
@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler{

	@org.springframework.web.bind.annotation.ExceptionHandler(ContactNumberAlreadyExistException.class)
	public ResponseEntity<ExceptionDetails> handleContactNumberAlreadyExist(ContactNumberAlreadyExistException e, WebRequest request) {
		
		ExceptionDetails  ed = new ExceptionDetails();
		
		ed.setMessage("ContactNumber Already Exist");
		ed.setUrl(request.getDescription(false));
		
		return new ResponseEntity<ExceptionDetails>(ed, HttpStatus.ALREADY_REPORTED);	
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(EmailAlreadyExistException.class)
	public ResponseEntity<ExceptionDetails> handleEmailAlreadyExist(EmailAlreadyExistException e, WebRequest request) {
		
		ExceptionDetails  ed = new ExceptionDetails();
		ed.setMessage("Email Already Exist");
		ed.setUrl(request.getDescription(false));
		return new ResponseEntity<ExceptionDetails>(ed, HttpStatus.ALREADY_REPORTED);	
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(UserNameAlreadyExistException.class)
	public ResponseEntity<ExceptionDetails> handleUserNameAlreadyExist(UserNameAlreadyExistException e, WebRequest request) {
		
		ExceptionDetails  ed = new ExceptionDetails();
		ed.setMessage("UserName Already Exist");
		ed.setUrl(request.getDescription(false));
		return new ResponseEntity<ExceptionDetails>(ed, HttpStatus.ALREADY_REPORTED);	
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionDetails> handleUserNotFound(UserNotFoundException e, WebRequest request) {
		
		ExceptionDetails  ed = new ExceptionDetails();
		ed.setMessage("User Not Found");
		ed.setUrl(request.getDescription(false));
		return new ResponseEntity<ExceptionDetails>(ed, HttpStatus.NOT_FOUND);	
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ListisEmptyException.class)
	public ResponseEntity<ExceptionDetails> handleListisEmpty(ListisEmptyException e, WebRequest request) {
		
		ExceptionDetails  ed = new ExceptionDetails();
		ed.setMessage("Test list is empty");
		ed.setUrl(request.getDescription(false));
//		System.out.println(ed.getMessage());
//		System.out.println(ed.getUrl());
		return new ResponseEntity<ExceptionDetails>(ed, HttpStatus.NO_CONTENT);	
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(TestAlreadyExistException.class)
	public ResponseEntity<ExceptionDetails> handleTestAlreadyExist(TestAlreadyExistException e, WebRequest request) {
		
		ExceptionDetails  ed = new ExceptionDetails();
		
		ed.setMessage("Test Already Exist");
		ed.setUrl(request.getDescription(false));
		return new ResponseEntity<ExceptionDetails>(ed, HttpStatus.ALREADY_REPORTED);	
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(TestNotFoundException.class)
	public ResponseEntity<ExceptionDetails> handleTestNotFound(TestNotFoundException e, WebRequest request) {
		
		ExceptionDetails  ed = new ExceptionDetails();
		ed.setMessage("Test Not Found");
		ed.setUrl(request.getDescription(false));
		return new ResponseEntity<ExceptionDetails>(ed, HttpStatus.NOT_FOUND);	
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(CenterNameAlreadyExistException.class)
	public ResponseEntity<ExceptionDetails> handleCenterNameAlreadyExist(CenterNameAlreadyExistException e, WebRequest request) {
		
		ExceptionDetails  ed = new ExceptionDetails();
		
		ed.setMessage("Center Already Exist");
		ed.setUrl(request.getDescription(false));
		return new ResponseEntity<ExceptionDetails>(ed, HttpStatus.ALREADY_REPORTED);	
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(CenterListIsEmptyException.class)
	public ResponseEntity<ExceptionDetails> handleCenterListIsEmpty(CenterListIsEmptyException e, WebRequest request) {
		
		ExceptionDetails  ed = new ExceptionDetails();
		
		ed.setMessage("Center List is empty");
		ed.setUrl(request.getDescription(false));
		return new ResponseEntity<ExceptionDetails>(ed, HttpStatus.NO_CONTENT);	
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(CenterNotFoundException.class)
	public ResponseEntity<ExceptionDetails> handleCenterNotFound(CenterNotFoundException e, WebRequest request) {
		
		ExceptionDetails  ed = new ExceptionDetails();
		
		ed.setMessage("Center no found");
		ed.setUrl(request.getDescription(false));
		return new ResponseEntity<ExceptionDetails>(ed, HttpStatus.NOT_FOUND);	
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(AppointmentAlreadyApprovedException.class)
	public ResponseEntity<ExceptionDetails> handleAppointmentAlreadyApproved(AppointmentAlreadyApprovedException e, WebRequest request) {
		
		ExceptionDetails  ed = new ExceptionDetails();
		
		ed.setMessage("Appointment already approved");
		ed.setUrl(request.getDescription(false));
		return new ResponseEntity<ExceptionDetails>(ed, HttpStatus.NOT_FOUND);	
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(AppointmentNotFoundException.class)
	public ResponseEntity<ExceptionDetails> handleAppointmentNotFound(AppointmentNotFoundException e, WebRequest request) {
		
		ExceptionDetails  ed = new ExceptionDetails();
		
		ed.setMessage("Appointment is not available");
		ed.setUrl(request.getDescription(false));
		return new ResponseEntity<ExceptionDetails>(ed, HttpStatus.NOT_FOUND);	
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(SlotNotAvailableException.class)
	public ResponseEntity<ExceptionDetails> handleSlotNotAvailable(SlotNotAvailableException e, WebRequest request) {
		
		ExceptionDetails  ed = new ExceptionDetails();
		
		ed.setMessage("Slot is not available");
		ed.setUrl(request.getDescription(false));
		return new ResponseEntity<ExceptionDetails>(ed, HttpStatus.NOT_FOUND);	
	}
	
	
}