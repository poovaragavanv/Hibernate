package com.firstlevel.cache;



import org.hibernate.Session;

public class TestHibernateEhcache 
{	
	public static void main(String[] args) 
	{
		storeData();
		
		try
		{
			//Open the hibernate session
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			//fetch the department entity from database first time
			DepartmentEntity department = (DepartmentEntity) session.load(DepartmentEntity.class, new Integer(1));
			System.out.println(department.getName());
			
			//fetch the department entity again; Fetched from first level cache
			department = (DepartmentEntity) session.load(DepartmentEntity.class, new Integer(1));
			System.out.println(department.getName());
			
			//Let's close the session
			session.getTransaction().commit();
			session.close();
			
			//Try to get department in new session
			Session anotherSession = HibernateUtil.getSessionFactory().openSession();
			anotherSession.beginTransaction();
			
			//Here entity is already in second level cache so no database query will be hit
			department = (DepartmentEntity) anotherSession.load(DepartmentEntity.class, new Integer(1));
			System.out.println(department.getName());
			
			anotherSession.getTransaction().commit();
			anotherSession.close();
		}
		finally
		{
			System.out.println(HibernateUtil.getSessionFactory().getStatistics().getEntityFetchCount()); //Prints 1
			System.out.println(HibernateUtil.getSessionFactory().getStatistics().getSecondLevelCacheHitCount()); //Prints 1
			
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
