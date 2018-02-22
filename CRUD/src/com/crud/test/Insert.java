package com.crud.test;
import com.curd.bean.User;
import com.curd.dao.UserDao;
public class Insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User u=new User();
		u.setUsername("Ragavan");
		u.setPassword("123456");
		UserDao ud=new UserDao();
		ud.insert(u);
		System.out.println("record inserted successfully");

	}

}
