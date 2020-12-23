package com.iskconhaldia.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iskconhaldia.bean.User;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public User insertUser(User user) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
			session.save(user);
			//this will save user in DB and after commit is done user row 
			//from DB will automatically be assigned to user and we return it.
		session.getTransaction().commit();
		return user;
	}

	@Override
	public void deleteUser(int userId) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
			User user = session.load(User.class, userId);
			session.delete(user);
		session.getTransaction().commit();
	}

	@Override
	public User updateUser(User user) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
			User dbUser = session.get(User.class, user.getUserId());
			dbUser = dbUser.updateUser(user);
			session.save(dbUser);
		session.getTransaction().commit();
		return dbUser;
	}

	@Override
	public User getUser(int userId) {
		Session session = sessionFactory.openSession();
		User user = (User)session.get(User.class, userId);
		return user;
	}
	
}
