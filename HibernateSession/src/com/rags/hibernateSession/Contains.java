package com.rags.hibernateSession;
import org.hibernate.Session;

public class Contains {
	Session session = HibernateUtil.getSessionFactory().openSession();
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//session.contains() returns true for persistent instance.
		Student std = (Student)session.get(Student.class, 1);
		System.out.println(session.contains(std));
		//session.contains() returns false for detached instance.
		session.evict(std);
		System.out.println(session.contains(std));
		//session.contains() returns false for transient object.
		Student s = new Student();
		s.setId(1);
		s.setName("AA");
		System.out.println(session.contains(s));
	}
}
