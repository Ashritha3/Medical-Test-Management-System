create sequence center_centerId_sequence START WITH 1 INCREMENT BY 1;

create table center_info(
		centerId number(10,0) primary key,
		centerName varchar2(50) not null,		
);


create sequence test_testId_sequence START WITH 1 INCREMENT BY 1;

create table test_info(
		testId number(10,0) primary key,
		testName varchar2(50) not null
);

create table center_test(
		centerId number(10,0) not null,
		testId number(10,0) not null,
		FOREIGN KEY (centerId) REFERENCES center_info(centerId),
		FOREIGN KEY (testId) REFERENCES test_info(testId),
);


create sequence user_userId_sequence START WITH 1 INCREMENT BY 1;

create table user_info(
		userId number(10,0) primary key,
		userName varchar2(50) not null,
		userPassword varchar2(50) not null,
		contactNumber number(40) not null,
		userEmail varchar2(50) not null,
		userRole varchar2(30) not null,
		age number(10) not null,
		gender varchar2(50) not null

);


create sequence appointment_appointmentId_sequence START WITH 1 INCREMENT BY 1;

create table appointment_info(
		appointmentId number(10,0) primary key,
		userId number(10,0) not null,
		testId number(10,0) not null,
		dateTime smalldatetime not null,
		approved BIT(0),
		FOREIGN KEY (center) REFERENCES center_info(centerId)
);