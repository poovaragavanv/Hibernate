package com.rags.primarycache.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rags.primarycache.model.*;
import com.rags.primarycache.util.HibernateUtil;


public class PrimaryCacheEvict {
	public static void main(String[] args) {
		// Get session factory using Hibernate Util class
		SessionFactory sf = HibernateUtil.getSessionFactory();
		// Get session from Session factory
		Session session = sf.openSession();

		// Load the Employee details whose Id is 1
		Employee employee = (Employee) session.load(Employee.class, new Integer(1));
		displayEmployeeDetails(employee);

		session.evict(employee);
		
		// Load the same Employee again within the same Session but after evict
		employee = (Employee) session.load(Employee.class, new Integer(1));
		displayEmployeeDetails(employee);

		

		// Load the Employee details whose Id is 2
		Employee employee1 = (Employee) session.load(Employee.class, new Integer(2));
		displayEmployeeDetails(employee1);

		// Load the Employee details whose Id is 3
		Employee employee2 = (Employee) session.load(Employee.class, new Integer(3));
		displayEmployeeDetails(employee2);

		session.clear();

		//Load the employees after clearing the primary cache
		
		// Load the Employee details whose Id is 2
		employee1 = (Employee) session.load(Employee.class, new Integer(2));
		displayEmployeeDetails(employee);

		// Load the Employee details whose Id is 3
		employee2 = (Employee) session.load(Employee.class, new Integer(3));
		displayEmployeeDetails(employee2);

		session.close();
	}

	private static void displayEmployeeDetails(Employee employee) {
		System.out.println(
				"ID: " + employee.getEmployeeId() + " Age: " + employee.getAge() + " Salary: " + employee.getSalary());
	}

}
