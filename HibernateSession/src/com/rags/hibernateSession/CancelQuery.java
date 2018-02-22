package com.rags.hibernateSession;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.hibernate.Session;

public class CancelQuery {
	Session session = HibernateUtil.getSessionFactory().openSession();
	public static void main(String[] args) {
		ExecutorService exService = Executors.newFixedThreadPool(2);
		CancelQuery ob = new CancelQuery();
		exService.execute(ob.new ThreadOne());
		exService.execute(ob.new ThreadTwo());
	}
	class ThreadOne implements Runnable {
		@Override
		public void run() {
			List<?> std = session.createQuery("FROM Student").list();
			for(int i = 0; i<std.size(); i++) {
				Student s = (Student)std.get(i);
				System.out.println(s.getId()+", "+ s.getName());
			}
		}
	}
	class ThreadTwo implements Runnable {
		@Override
		public void run() {
			session.cancelQuery();
		}
	}
	protected  void finilize() {
		session.close();
	}
}
