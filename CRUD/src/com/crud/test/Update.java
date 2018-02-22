package com.crud.test;
import com.curd.bean.User;
import com.curd.dao.UserDao;
public class Update 
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User u=new User();
		u.setId(2);
		u.setUsername("Sample");
		u.setPassword("123456789");
		UserDao ud=new UserDao();
		ud.updateUser(u);
		System.out.println("record updated successfully");


	}

}
