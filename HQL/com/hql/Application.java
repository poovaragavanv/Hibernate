package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



public class Application {
	private static SessionFactory factory = null;
	
	public static void main(String[] args) {
		
		System.out.println("============Set up Session Factory============");
			setUpSessionFactory();
			// Show all customer tables
			
			System.out.println("==============FROM CLAUSE: hql = 'FROM Customer'==============");
			fromClause();
			
			System.out.println("==============AS CLAUSE: hql = FROM Customer AS C==============");
			asClause();
			
			System.out.println("==============SELECT CLAUSE: hql = SELECT C.firstName, C.age FROM Customer C==============");
			selectClause();
			
			System.out.println("==============WHERE CLAUSE: hql = FROM Customer C WHERE C.age = 20==============");
			whereClause();
			
			System.out.println("==============ORDER BY CLAUSE: hql = FROM Customer C WHERE C.age > 25 ORDER BY C.id DESC==============");
			orderByClause();
			
			System.out.println("==============GROUP BY CLAUSE: hql = SELECT COUNT(*), C.firtName FROM Customer C ==============");
			groupByClause();
			
			System.out.println("==============NAMED PARAMETERS CLAUSE: hql = FROM Customer C WHERE C.id = 1==============");
			namedParameters();
			
			System.out.println("==============UPDATE CLAUSE: UPDATE Customer set age = :custAge WHERE id = :customerId==============");
			updateClause();
			
			System.out.println("==============DELETE CLAUSE: hql = DELETE FROM Customer WHERE id = 2==============");
			deleteClause();
			
			shutdown();
	}
	
	/**
	 * Set SessionFactory
	 */
	public static void setUpSessionFactory() {
		// create sessionFactory
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	/**
	 * Shutdown
	 */
	public static void shutdown(){
		factory.close();
	}
	
	/**
	 * From Clause
	 */
	public static void fromClause(){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			
			String hql = "FROM Customer";
			Query<Customer> query = session.createQuery(hql, Customer.class);
			List<Customer> custList = query.list();
			
			custList.forEach(System.out::println);
			
			tx.commit();
		}catch(Exception e){
			if(null != tx){
				tx.rollback();
			}
		}finally{
			session.close();
		}
	}
	
	/**
	 * As Clause
	 */
	public static void asClause(){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			
			String hql = "FROM Customer AS C";
			// Above statement is the same with statement: String hql = "FROM Customer C";
			Query<Customer> query = session.createQuery(hql, Customer.class);
			List<Customer> custList = query.list();
			
			custList.forEach(System.out::println);
			
			tx.commit();
		}catch(Exception e){
			if(null != tx){
				tx.rollback();
			}
		}finally{
			session.close();
		}
	}
	
	/**
	 * Select Clause
	 */
	public static void selectClause(){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			
			String hql = "SELECT C.firstName, C.age FROM Customer C";
			Query query = session.createQuery(hql);
			List<Object[]> objectList= query.list();
			objectList.forEach(obj->{
				String info = String.format("Customer's Info has firstname = %s, age = %d", (String)obj[0], (Integer)obj[1]);
				System.out.println(info);
			});
			
			tx.commit();
		}catch(Exception e){
			if(null != tx){
				tx.rollback();
			}
		}finally{
			session.close();
		}
	}
	
	/**
	 * 
	 * WHERE Clause 
	 */
	
	public static void whereClause(){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			
			String hql = "FROM Customer C WHERE C.age = 20";
			Query<Customer> query = session.createQuery(hql, Customer.class);
			List<Customer> custList = query.list();

			custList.forEach(System.out::println);
			
			tx.commit();
		}catch(Exception e){
			if(null != tx){
				tx.rollback();
			}
		}finally{
			session.close();
		}
	}
	
	/**
	 * 
	 * OrderBy Clause
	 */
	public static void orderByClause(){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			
			String hql = "FROM Customer C WHERE C.age > 25 ORDER BY C.id DESC";
			Query<Customer> query = session.createQuery(hql, Customer.class);
			List<Customer> custList = query.list();
			
			custList.forEach(System.out::println);
			
			tx.commit();
		}catch(Exception e){
			if(null != tx){
				tx.rollback();
			}
		}finally{
			session.close();
		}
	}
	
	/**
	 * 
	 * Group By Clause
	 */
	public static void groupByClause(){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			
			String hql = "SELECT COUNT(*), C.firstName FROM Customer C " +
			         "GROUP BY C.firstName";
			Query query = session.createQuery(hql);
			List<Object[]> objLst = query.list();
			objLst.forEach(obj->{
				String info = String.format("Having %d Customers has name is %s", (Long)obj[0], (String)obj[1]);
				System.out.println(info);
			});
			
			tx.commit();
		}catch(Exception e){
			if(null != tx){
				tx.rollback();
			}
		}finally{
			session.close();
		}
	}
	
	/**
	 * 
	 * Using Named Parameter
	 */
	public static void namedParameters(){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			
			String hql = "FROM Customer C WHERE C.id = :customerId";
			Query<Customer> query = session.createQuery(hql, Customer.class);
			query.setParameter("customerId",1);
			
			List<Customer> custList = query.list();
			
			custList.forEach(System.out::println);
			
			tx.commit();
		}catch(Exception e){
			if(null != tx){
				tx.rollback();
			}
		}finally{
			session.close();
		}
	}
	
	/**
	 * 
	 * Update Clause
	 */
	public static void updateClause(){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			
			String hql = "UPDATE Customer set age = :custAge WHERE id = :customerId";
			Query query = session.createQuery(hql);
			query.setParameter("custAge",26);
			query.setParameter("customerId",3);
			
			int affectedRows = query.executeUpdate();
			System.out.println("Rows affected: " + affectedRows);
			
			tx.commit();
		}catch(Exception e){
			if(null != tx){
				tx.rollback();
			}
		}finally{
			session.close();
		}
	}
	
	/**
	 * Delete Clause
	 */
	public static void deleteClause(){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			
			String hql = "DELETE FROM Customer WHERE id = :customerId";
			Query query = session.createQuery(hql);
			query.setParameter("customerId", 2);
			
			int affectedRows = query.executeUpdate();
			System.out.println("Rows affected: " + affectedRows);
			
			tx.commit();
		}catch(Exception e){
			if(null != tx){
				tx.rollback();
			}
		}finally{
			session.close();
		}
	}
}