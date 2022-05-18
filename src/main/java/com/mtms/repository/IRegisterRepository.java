package com.mtms.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.mtms.model.User;

/*******************************************************************************************************************************
 
-Description              :     CrudRepository Interface of Register Management System

*******************************************************************************************************************************/

public interface IRegisterRepository extends CrudRepository<User, Integer>{

    public User getUserByUserName(String userName);
	
	public User getUserByContactNumber(BigInteger contactNumber);
	
	public User getUserByUserEmail(String userEmail);
	
    public User getUserByUserNameAndUserPassword(String userName,String userPassword);
}
