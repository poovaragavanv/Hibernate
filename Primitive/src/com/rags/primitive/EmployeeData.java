package com.rags.primitive;

import org.hibernate.*;
import org.hibernate.cfg.*;
 
public class EmployeeData { 
 
    @SuppressWarnings("deprecation")
	public static void main(String[] args)
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Employee employee = new Employee(); 
        employee.setEmployeeId(1);
        employee.setEmployeeName("Ragavan");
        // employee.setEmployeeSalary(1000.0); not setting any value to Salary 
        Transaction tx = session.beginTransaction();
        session.save(employee);
        System.out.println("Object saved successfully.....!!");
        tx.commit();
        session.close();
        factory.close();
    }
 
}
