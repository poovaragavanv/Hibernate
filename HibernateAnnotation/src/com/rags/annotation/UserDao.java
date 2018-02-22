package com.rags.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDao {
	public static void main(String[] args) {
		User u=new User();
		u.setUsername("Ragavan");
		u.setPassword("12345678");
		@SuppressWarnings("deprecation")
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session =factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(u);
		tx.commit();
		session.close();	
		System.out.println("Record inserted");
	}	
}
