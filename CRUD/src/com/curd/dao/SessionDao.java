package com.curd.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class SessionDao {

	private static SessionFactory factory;
	private Session session = null;
	static {

		factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public Session getSession() {
		if (session == null) {
			session = factory.openSession();
		}
		return session;
	}

}
