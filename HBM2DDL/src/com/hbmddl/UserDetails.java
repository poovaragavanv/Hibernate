package com.hbmddl;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeedata")
public class UserDetails 
{
	@Id
    private int userId;
	
	@Column(name="emp_name")
	private String userName;
	
    public int getUserId() 
    {
        return userId;
    }
    public void setUserId(int userId) 
    {
        this.userId = userId;
    }
    public String getUserName() 
    {
        return userName;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }
}