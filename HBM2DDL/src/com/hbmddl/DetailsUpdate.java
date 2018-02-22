package com.hbmddl;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
@SuppressWarnings("deprecation")
public class DetailsUpdate {

	public static void main(String[] args) 
    {
       //Create the model object 
       UserDetails user1 = new UserDetails();
       UserDetails user2 = new UserDetails();
        user1.setUserId(1);
        user1.setUserName("ABCD");
        user2.setUserId(2);
        user2.setUserName("EFGH");
       // Create Session Factory Object  – using annotation configuration object
        SessionFactory sessionFactory = new AnnotationConfiguration().configure("NewFile.cfg.xml").buildSessionFactory();  
    
      //Create Session object from session factory object
        Session session = sessionFactory.openSession();
        session.beginTransaction();
    
       //Use the session to save model objects
        session.save(user1);
        session.save(user2);
        session.getTransaction().commit();
        session.close();
       }
}
