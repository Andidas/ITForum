package testService;

import org.junit.Test;

import service.UserService;
import entity.User;

public class user {
	@Test 
	public void queryUserOne(){
		User user = new UserService().queryUserOne("16");
		System.out.println(user);
	}
}
