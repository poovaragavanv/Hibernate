/* 
 * POJO class(Student.java)
 * Hibernate configuration file(hibernate.cfg.xml)
 * Hibernate mapping file(Student.hbm.xml)
 * Main Program(StudentInfo.java)
 */

package com.rags.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentInfo 
{
	public static void main(String args[]) throws Exception 
	{
		String name = "Ragavan";
		String degree = "MSC";
		String phone = "098776544";
		String email = "vpoovaragavan@outlook.com";

		Student s1 = new Student();
		s1.setDegree(degree);
		s1.setEmail(email);
		s1.setName(name);
		s1.setPhone(phone);

		try 
		{
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
			Session s = sessionFactory.openSession();
			Transaction tx = s.beginTransaction();
			s.save(s1);
			tx.commit();
			s.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.err.println("Initial SessionFactory creation failed." + e);
		}
		System.out.println("Added to Database");
	}
}