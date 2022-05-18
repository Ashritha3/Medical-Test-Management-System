insert into user_info(userId,userName,userPassword,contactNumber,userEmail,userRole,age,gender) values(
	user_userId_sequence.nextVal,
	'VamsiGampa',
	'Vamsi@123',
	9642919441,
	'vamsi@gmail.com',
	'Admin',
	23,
	'male'
);

insert into user_info(userId,userName,userPassword,contactNumber,userEmail,userRole,age,gender) values(
	user_userId_sequence.nextVal,
	'AtulKumar',
	'Atul@123',
	9641335599,
	'atul@gmail.com',
	'User',
	24,
	'male'
);

insert into center_info(centerId,centerName) values(
	center_centerId_sequence.nextVal,
	'Maa Diagnostics'
);

insert into center_info(centerId,centerName) values(
	center_centerId_sequence.nextVal,
	'Tesla Diagnostics'
);

insert into test_info(testId,testName) values(
	test_testId_sequence.nextVal,
	'CT Scan'
);

insert into test_info(testId,testName) values(
	test_testId_sequence.nextVal,
	'Blood test'
);

insert into test_info(testId,testName) values(
	test_testId_sequence.nextVal,
	'MRI Scan'
);

insert into test_info(testId,testName) values(
	test_testId_sequence.nextVal,
	'X-Ray'
);

insert into test_info(testId,testName) values(
	test_testId_sequence.nextVal,
	'Thyroid test'
);

insert into appointment_info(appointmentId,userId,testId,dateTime,approved,center) values(
	appointment_appointmentId_sequence.nextVal,
	1,
	2,
	'2022/05/23T04:30',
	0,
	1
);

insert into appointment_info(appointmentId,userId,testId,dateTime,approved,center) values(
	appointment_appointmentId_sequence.nextVal,
	1,
	3,
	'2022/05/28T05:30',
	0,
	2
);