package com.hbmddl;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
@SuppressWarnings("deprecation")
public class DetailsCreate2 {

	public static void main(String[] args) 
    {
       //Create the model object 
       		UserDetails user1 = new UserDetails();
       		UserDetails user2 = new UserDetails();
        	user1.setUserId(3);
        	user1.setUserName("IJKL");
        	user2.setUserId(4);
        	user2.setUserName("MNOP");  
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
