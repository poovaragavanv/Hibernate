package com.util;

import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import com.emb.*;
@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static final SessionFactory concreteSessionFactory;
	static {
		try {

			Properties prop= new Properties();
			prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
			prop.setProperty("hibernate.connection.username", "root");
			prop.setProperty("hibernate.connection.password", "admin");
			prop.setProperty("hibernate.hbm2ddl.auto", "update");
			prop.setProperty("show_sql", "true");
			prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
			
			concreteSessionFactory = new AnnotationConfiguration()
		   .addPackage("com.concretepage.persistence")
				   .addProperties(prop)
				   .addAnnotatedClass(Person.class)
				   .addAnnotatedClass(EmployeeInfo.class)
				   .buildSessionFactory();
			
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() throws HibernateException {
		return concreteSessionFactory.openSession();
	}

	public static void main(String... args) {
		Session session = getSession();
		session.beginTransaction();
		Person person= new Person("ABC", "DEF");
		EmployeeInfo s= new EmployeeInfo(person, "Coimbatore");
		session.save(s);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully Embedded");
	}
}
 