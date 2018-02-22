package com.Date;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="tmstmp")
public class DateAndTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date date;
    @Temporal(TemporalType.TIME)
    private Date time;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

    private Date dateField;
    private Time timeField;
    private Timestamp timestampField;

    public DateAndTime() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Date getDateField() {
        return dateField;
    }

    public void setDateField(Date dateField) {
        this.dateField = dateField;
    }

    public Time getTimeField() {
        return timeField;
    }

    public void setTimeField(Time timeField) {
        this.timeField = timeField;
    }

    public Timestamp getTimestampField() {
        return timestampField;
    }

    public void setTimestampField(Timestamp timestampField) {
        this.timestampField = timestampField;
    }

    @Override
    public String toString() {
        return "DateAndTime{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                ", dateTime=" + dateTime +
                ", dateField=" + dateField +
                ", timeField=" + timeField +
                ", timestampField=" + timestampField +
                '}';
    }
}
