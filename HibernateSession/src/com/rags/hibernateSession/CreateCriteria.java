package com.rags.hibernateSession;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class CreateCriteria {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<?> std = session.createCriteria(Student.class).
				add(Restrictions.le("id", 2)).addOrder(Order.asc("name")).list();
		for(int i = 0; i<std.size(); i++) {
			Student s = (Student)std.get(i);
			System.out.println(s.getId()+", "+ s.getName());
		}
		session.close();
	}
}
