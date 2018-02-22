package com.api;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
 
public class HibernateAPI {
    SessionFactory factory;
    
    public static void main(String[] args) {
        Session session = HibernateSessionUtil.getSession();
        saveEmployee(session);
        getEmployee(session);
        firstLevelCache(session);
        removeobject(session);
        clear(session);
        
        }
 
    public static void saveEmployee(Session session) {
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setAge(30);
        
 
        Transaction trn = session.beginTransaction();
        session.persist(employee);
        trn.commit();
    }
 
    @SuppressWarnings("unchecked")
	public static void getEmployee(Session session) {
        List<Employee> emplList = session.createQuery("from Employee").list();
        for (Employee emp : emplList)
            System.out.println(emp);
 
    }
    Session session = factory.openSession();
    
    public static void firstLevelCache(Session session) 
    {
    System.out.println("Querying for John for the first time");
    Employee emp1 = (Employee) session.load(Employee.class, 1);
    System.out.println("Employee Details : " + emp1);
    System.out.println("Querying for John for the second time");
    Employee emp2 = (Employee) session.load(Employee.class, 1);
    System.out.println("Employee Details : " + emp2);
    // session.close();
    }
    public static void removeobject(Session session)
    {
    System.out.println("Querying for John for the first time");
    Employee emp1 = (Employee) session.load(Employee.class, 1);
    System.out.println("Employee Details : " + emp1);
     
    //Evicting details for John from session cache
    session.evict(emp1);        
    }
    public static void clear(Session session)
    {
    	System.out.println("Querying for John for the first time");
    	Employee emp1 = (Employee) session.load(Employee.class, 1);
    	System.out.println("Employee Details : " + emp1);
    	System.out.println("Querying for Dave for the first time");
    	Employee emp2 = (Employee) session.load(Employee.class, 2);
    	System.out.println("Employee Details : " + emp2);
    	 
    	//Clear all cached objects from session
    	session.clear();        
    	 
    	System.out.println("Querying for John for the second time");
    	Employee emp1_1 = (Employee) session.load(Employee.class, 1);
    	System.out.println("Employee Details : " + emp1_1);
    	System.out.println("Querying for Dave for the second time");
    	Employee emp1_2 = (Employee) session.load(Employee.class, 2);
    	System.out.println("Employee Details : " + emp1_2);
    }
    
    public static void closeob(Session session)
    {
    	session.close();
    }
   }
    
 
