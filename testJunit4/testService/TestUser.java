package testService;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.User;
import service.UserService;

public class TestUser {
	private static UserService us = new UserService();

	
	@Test 
	public void  addUser(){
		assertTrue(us.addUser("test", "test@qq.com", "test"));
		assertTrue(us.isNameExist("test"));
		assertTrue(us.checkUser("test@qq.com", "test"));
	}
	
	@Test 
	public void  queryUserOne(){
		us.queryUserOne("16");
	}
	@Test 
	public void  queryUserList(){
		System.out.println(us.queryUserList());
	}
	@Test
	public void updateUser(){
		User user = us.queryUser("test@qq.com");
		us.updateUser(user.getUid(), user.getUname(), user.getUhead(), user.getUemail(), "1", "12-21", "I am you lover~");
		System.out.println(us.queryUserOne(user.getUid()+""));
	}
	@Test 
	public void  modifyPasswordByEmail(){
		assertTrue(us.modifyPasswordByEmail("test@qq.com", "test"));
		System.out.println(us.queryUser("test@qq.com"));
	}
	
}
