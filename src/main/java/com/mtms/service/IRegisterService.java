package com.mtms.service;

import com.mtms.model.User;
import com.mtms.model.UserList;

/*******************************************************************************************************************************

-Description              :    Service Interface for Register Management System

*******************************************************************************************************************************/

public interface IRegisterService {
	
    User registerUser(User user);
	
	User getUserById(Integer userId);
	
	UserList getAllUsers();
	
	User loginUser(String userName,String userPassword); 
	
	boolean removeUserById(Integer userId);

}
