package com.secondlevel;

import org.hibernate.Session;

public class TestHibernateEhcache {
	
	public static void main(String[] args) 
	{
		storeData();
		
		//Open the hibernate session
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try
		{
			//Entity is fecthed very first time
			DepartmentEntity department = (DepartmentEntity) session.load(DepartmentEntity.class, new Integer(1));
			System.out.println(department.getName());
			
			//fetch the department entity again
			department = (DepartmentEntity) session.load(DepartmentEntity.class, new Integer(1));
			System.out.println(department.getName());
			
			session.evict(department);
			
			department = (DepartmentEntity) session.load(DepartmentEntity.class, new Integer(1));
			System.out.println(department.getName());
			
			Session anotherSession = HibernateUtil.getSessionFactory().openSession();
			anotherSession.beginTransaction();
			
			department = (DepartmentEntity) anotherSession.load(DepartmentEntity.class, new Integer(1));
			System.out.println(department.getName());
			
			anotherSession.getTransaction().commit();
			
		}
		finally
		{
			System.out.println(HibernateUtil.getSessionFactory().getStatistics().getEntityFetchCount());
			System.out.println(HibernateUtil.getSessionFactory().getStatistics().getSecondLevelCacheHitCount());
			
			session.getTransaction().commit();
			HibernateUtil.shutdown();
		}
	}
	
	private static void storeData()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		DepartmentEntity department = new DepartmentEntity();
		department.setName("Human Resource");
		
		session.save(department);

		session.getTransaction().commit();
	}

}
