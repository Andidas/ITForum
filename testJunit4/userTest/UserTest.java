package userTest;

import java.util.List;

import org.junit.Test;

import entity.User;
import service.UserService;

public class UserTest {
	
	@Test
	public void searchUserList(){
		UserService userService = new UserService();
		List<User> ul = userService.queryUserList();
		for (User u : ul) {
			System.out.println(u);
		}
	}
	@Test
	public void  queryUser(){
		UserService userService = new UserService();
		User u = userService.queryUser("824@qq.com");
		System.out.println(u);
	}
	@Test
	public void checkUser() {
		UserService userService = new UserService();
		System.out.println(userService.checkUser("824@qq.com","123"));
	}
}
