package com.iskconhaldia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iskconhaldia.bean.User;
import com.iskconhaldia.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("working")
	public String getMessage(){
		return "Working fine, well done!";
	}
	
	@RequestMapping(value = "user/{userId}",
	produces = MediaType.APPLICATION_JSON_VALUE,
	method = RequestMethod.GET)
	public User getUserById(@PathVariable int userId) {
		return userService.getUserById(userId);
	}
	
	@RequestMapping(value="user/update",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@RequestMapping(value="user/create",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	public User insertUser(@RequestBody User user) {
		return userService.insertUser(user);
	}
	
	@RequestMapping(value = "user/{userId}",
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.DELETE)
	public String deleteUserById(@PathVariable int userId) {
		userService.deleteUserById(userId);
		return "User got deleted successfully";
	}
	
	
	
	
	
	
	
}
