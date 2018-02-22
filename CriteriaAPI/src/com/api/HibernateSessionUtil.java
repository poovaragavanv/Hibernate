package com.api;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

 
public class HibernateSessionUtil {
    private static HibernateSessionUtil instance = new HibernateSessionUtil();
    private static SessionFactory factory;
 
    private HibernateSessionUtil() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        factory = configuration.buildSessionFactory();
    }
 
    @SuppressWarnings("static-access")
	public static Session getSession() {
        return getInstance().factory.openSession();
    }
 
    public static HibernateSessionUtil getInstance() {
        return instance;
    }
 
}