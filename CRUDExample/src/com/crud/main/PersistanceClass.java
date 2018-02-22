package com.crud.main;

import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crud.HibernateUtil.HibernateUtil;
import com.crud.hibernate.Employee;

public class PersistanceClass 
{
	public static void main(String[] args) 
	{
		PersistanceClass persistobj = new PersistanceClass();
		persistobj.saveEmployee("ABC", "CEO", 100000, 893965);
		persistobj.saveEmployee("CDE", "Manager", 50000, 996654);
		persistobj.saveEmployee("FGH", "Assistant", 45000, 93445);
		persistobj.retriveEmployee();
		persistobj.deleteEmployee();
		persistobj.updateEmployee();
	}

	public void saveEmployee(String name, String city, int sal, int phone) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try 
		{
			transaction = session.beginTransaction();
			Employee employee = new Employee();
			employee.setName("name");
			employee.setSal(sal);
			employee.setCity("city");
			employee.setPhone(phone);
			session.save(employee);
			transaction.commit();
			System.out.println("Records inserted sucessessfully");
		} 
		catch(HibernateException e) 
		{
			transaction.rollback();
			e.printStackTrace();
		} 
		finally 
		{
			session.close();
		}
	}
	@SuppressWarnings("rawtypes")
	public void retriveEmployee()

	{

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try 
		{
			transaction = session.beginTransaction();
			List employee = session.createQuery("from Employee").list();
			for (Iterator iterator = employee.iterator(); iterator.hasNext();) 
			{
				Employee employee1 = (Employee) iterator.next();
				System.out.println(employee1.getName() + "  "
						+ employee1.getCity() + "  " + employee1.getSal()
						+ "   " + employee1.getPhone());
			}
			transaction.commit();

		} 
		catch (HibernateException e) 
		{
			transaction.rollback();
			e.printStackTrace();

		} finally 
		{

			session.close();

		}
	}
	
	public void deleteEmployee() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try 
		{
			transaction = session.beginTransaction();
			String queryString = "from Employee where phone = :phone";
			Query query = session.createQuery(queryString);
			query.setInteger("phone", 893965);
			Employee employee = (Employee) query.uniqueResult();
			session.delete(employee);
			System.out.println("Employee records deleted!");

		} 
		catch (HibernateException e) 
		{
			transaction.rollback();
			e.printStackTrace();

		}
		finally 
		{
			session.close();
		}
	}

	public void updateEmployee() 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try 
		{
			transaction = session.beginTransaction();
			String queryString = "from Employee where sal = :sal";
			Query query = session.createQuery(queryString);
			query.setInteger("sal", 50000);
			Employee employee = (Employee) query.uniqueResult();
			employee.setSal(60000);
			session.update(employee);
			System.out.println("Employee records updated!");
		} 
		catch (HibernateException e) 
		{
			transaction.rollback();
			e.printStackTrace();

		} 
		finally 
		{
			session.close();
		}
	}
}
