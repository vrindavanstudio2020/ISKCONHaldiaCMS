package com.iskconhaldia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iskconhaldia.bean.User;
import com.iskconhaldia.dao.UserDAO;

@Service
public class UserService {
	
	@Autowired
	UserDAO userdao;
	
	public User getUserById(int userId) {
		return userdao.getUser(userId);
	}
	
	public User updateUser(User user) {
		return userdao.updateUser(user);
	}
	
	public void deleteUserById(int userId) {
		userdao.deleteUser(userId);
	}
	
	public User insertUser(User user) {
		return userdao.insertUser(user);
	}
	
}
