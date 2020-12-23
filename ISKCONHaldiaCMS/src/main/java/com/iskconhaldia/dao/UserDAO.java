package com.iskconhaldia.dao;

import com.iskconhaldia.bean.User;

public interface UserDAO {
	public User insertUser(User user);
	public void deleteUser(int userId);
	public User updateUser(User user);
	public User getUser(int userId);
}
