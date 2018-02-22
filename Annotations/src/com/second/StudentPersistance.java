package com.second;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;


@SuppressWarnings("deprecation")
public class StudentPersistance {
	public static void main(String[] args) {
		Session session = new AnnotationConfiguration().configure("NewFile.cfg.xml")
				.buildSessionFactory().openSession();

		Transaction t = session.beginTransaction();
		StudentData student = new StudentData();
		student.setId(1);
		student.setName("Ragavan");
		student.setRoll("101");
		student.setDegree("MSc COmputer Science");
		student.setPhone("99999");
		StudentData student1 = new StudentData();
		student.setId(2);
		student.setName("Poovaragavan");
		student.setRoll("102");
		student.setDegree("MSc Computer Science");
		student.setPhone("934499");

		session.persist(student);
		session.persist(student1);

		t.commit();
		session.close();
		System.out.println("successfully saved");

	}
}
