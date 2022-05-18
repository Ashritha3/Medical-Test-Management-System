package com.mtms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtms.exception.register.ContactNumberAlreadyExistException;
import com.mtms.exception.register.EmailAlreadyExistException;
import com.mtms.exception.register.UserNameAlreadyExistException;
import com.mtms.exception.register.UserNotFoundException;
import com.mtms.model.User;
import com.mtms.model.UserList;
import com.mtms.repository.IRegisterRepository;

/*******************************************************************************************************************************

-Description              :     RegisterServiceImpl Class implements services for RegisterService Management System

*******************************************************************************************************************************/

@Service
public class RegisterServiceImpl implements IRegisterService{
	
	@Autowired
	private IRegisterRepository registerRepo;
	
	String errorMessage=" is Already Exist";
	
	
	/*******************************************************************************************************************************
	-Function Name            :     registerUser
	-Input Parameters         :     user Object
	-Return Type              :     added user object
	-Throws                   :     UserNameAlreadyExistException,ContactNumberAlreadyExistException,EmailAlreadyExistException
	-Description              :     adding user to the database
	*******************************************************************************************************************************/
	
	@Override
	public User registerUser(User user) {
		

		if(registerRepo.getUserByUserName(user.getUserName())!=null)
			throw new UserNameAlreadyExistException("User with Name "+user.getUserName()+errorMessage);
		
		if(registerRepo.getUserByContactNumber(user.getContactNumber())!=null)
			throw new ContactNumberAlreadyExistException("User with ContactNumber "+user.getContactNumber()+errorMessage);
		
		if(registerRepo.getUserByUserEmail(user.getUserEmail())!=null)
			throw new EmailAlreadyExistException("User with Email "+user.getUserEmail()+errorMessage);
		System.out.println(registerRepo.save(user));
		return registerRepo.save(user);
	}

	/*******************************************************************************************************************************
	-Function Name            :     getUserById
	-Input Parameters         :     user
	-Return Type              :     user object
	-Throws                   :     UserNotFoundException
	-Description              :     getting a user from the database
	*******************************************************************************************************************************/
	
	@Override
	public User getUserById(Integer userId) {
		User user = null;
		Optional<User> opt = registerRepo.findById(userId);
		if(opt.isEmpty()) {
			throw new UserNotFoundException("User with Id "+userId+" is not found");
		}
		else {
			user = opt.get();
		}
		return user;
	
	}

	/*******************************************************************************************************************************
	-Function Name            :     getAllUsers
	-Input Parameters         :     -
	-Return Type              :     List of users
	-Throws                   :     -
	-Description              :     getting all users from the database
	*******************************************************************************************************************************/
	@Override
	public UserList getAllUsers() {
	
		List<User> users = new ArrayList<User>();
		Iterable<User> it = registerRepo.findAll();
		it.forEach((user) -> {
			users.add(user);
		});
		return new UserList(users);
	
	}

	/*******************************************************************************************************************************
	-Function Name            :     loginUser
	-Input Parameters         :     userName,userPassword
	-Return Type              :     User object
	-Throws                   :     UserNotFoundException
	-Description              :     getting a user from the database
	*******************************************************************************************************************************/
	
	@Override
	public User loginUser(String userName, String userPassword) {
        
	   User user=registerRepo.getUserByUserNameAndUserPassword(userName, userPassword);

		if (user == null) {
			throw new UserNotFoundException("Invalid UserName and Password");
		}
		 return user;
	}

	/*******************************************************************************************************************************
    -Function Name            :     removeUserById
    -Input Parameters         :     user Object
    -Return Type              :     boolean
    -Throws                   :     -
    -Description              :     removing user to the database
    *******************************************************************************************************************************/
	
	@Override
	public boolean removeUserById(Integer userId) {
		registerRepo.deleteById(userId);
		return true;
	}
}
