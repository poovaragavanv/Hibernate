package com.rags.tablepersubclas;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BookDao {

	SessionFactory sessionFactory;

	@SuppressWarnings("deprecation")
	private Session getSession() {
		Session s = null;
		try {
			sessionFactory = (SessionFactory) new Configuration().configure()
					.buildSessionFactory();
			s = sessionFactory.openSession();

		} catch (Exception e) {
			System.out.println(e);
		}
		return s;
	}

	public void insertBook(Book bk) {
		try {
			Session s = getSession();
			Transaction transaction = s.beginTransaction();
			s.save(bk);
			transaction.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	public Book getBook(int id) {
		Book sd = null;
		try {
			Session s = getSession();

			sd = (Book) s.get(Book.class, id);

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		return sd;
	}

}
