package com.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class App {

    public static void main (String...args){

        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();

        Date now = new Date();

        DateAndTime date = new DateAndTime();
        date.setDate(now);
        date.setTime(now);
        date.setDateTime(now);

        date.setDateField(now);
        date.setTimeField(new Time(now.getTime()));
        date.setTimestampField(new Timestamp(now.getTime()));

        session.save(date);
        tx.commit();

        @SuppressWarnings("unchecked")
		List<DateAndTime> dateAndTimes = (List<DateAndTime>)session.createQuery("from DateAndTime").list();
        System.out.println(Arrays.toString(dateAndTimes.toArray()));

        session.close();
        HibernateUtil.shutdown();
    }
}
