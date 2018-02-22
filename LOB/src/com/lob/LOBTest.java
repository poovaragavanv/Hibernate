package com.lob;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class LOBTest {
   public static void main(String args[]) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction transaction = null;
        try {
           
            transaction = session.beginTransaction();
            File resume = new File("D:\\Resume.doc");
            byte[] fileContent = new byte[(int) resume.length()];
            try {
       	     	FileInputStream fileInputStream = new FileInputStream(resume);
       	     	//convert file into array of bytes
       	     	fileInputStream.read(fileContent);
       	     	fileInputStream.close();
            } catch (Exception e) {
       	     	e.printStackTrace();
            }
            Blob blob = Hibernate.createBlob(fileContent);
            User user = new User();
            user.setName("RAGAVAN");
            user.setContent(blob);
            session.save(user);
            transaction.commit();
        }catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        readResume(1);
     }
    
    public static void readResume(Integer userId) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction transaction = null;
        try {
             
            transaction = session.beginTransaction();
            List employees = session.createQuery("from User where userId ='" + userId + "'").list();
            for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
                User user = (User) iterator.next();
                Blob blob = user.getContent();
                FileOutputStream fos = new FileOutputStream("D:\\Resume1.doc"); 
                fos.write(blob.getBytes(1, (int)blob.length()));
                fos.close();
            }
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}