package com.mtms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mtms.model.User;
import com.mtms.model.UserList;
import com.mtms.service.IRegisterService;

/*******************************************************************************************************************************

-Description              :     RegisterController Class for accessing Register service fot Medical test management service

*******************************************************************************************************************************/

@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
public class RegisterController {

	@Autowired
	private IRegisterService registerService;
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) 
	{
		return registerService.registerUser(user);
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable Integer id) {
		return registerService.getUserById(id);
	}
	
	@GetMapping("/getallusers")
	public UserList getAllUsers()
	{
		return registerService.getAllUsers();
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User user)
	
	{
		String username=user.getUserName();
		String password=user.getUserPassword();
		User userObj=null;
		if(username!=null && password!=null) {
			userObj=registerService.loginUser(username, password);
		}
	
		return userObj;
	}
	
	@DeleteMapping("/removeuser/{userId}")
	public boolean removeUser(@PathVariable Integer userId)
	{
		return registerService.removeUserById(userId); 
	}
}
