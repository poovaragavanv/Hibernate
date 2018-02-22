package com.curd.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.curd.bean.User;

public class UserDao {

	private Session session = null;

	public void insert(User u) {
		SessionDao sd = new SessionDao();
		session = sd.getSession();
		Transaction tx = session.beginTransaction();
		session.save(u);
		tx.commit();
		session.close();
	}

	public User getUser(Long id) {
		SessionDao sd = new SessionDao();
		session = sd.getSession();
		User u = (User) session.get(User.class, id);
		session.close();
		return u;
	}

	@SuppressWarnings("unchecked")
	public List<User> getUserList() {
		SessionDao sd = new SessionDao();
		session = sd.getSession();
		List<User> li = session.createCriteria(User.class).list();
		session.close();
		return li;
	}

	public void deleteUser(Long id) {
		SessionDao sd = new SessionDao();
		session = sd.getSession();
		User u = (User) session.load(User.class, id);
		Transaction tx = session.beginTransaction();
		session.delete(u);
		tx.commit();
		session.close();
	}
	
	public void updateUser(User u) {
		SessionDao sd = new SessionDao();
		session = sd.getSession();
		User user = (User) session.load(User.class, u.getId());
		user.setPassword(u.getPassword());
		user.setUsername(u.getUsername());
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
		session.close();
	}
}
