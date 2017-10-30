package userTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import entity.User;
import service.UserService;

public class UserTest {
	UserService userService = new UserService();
	
	@Test
	public void searchUserList(){
		List<User> ul = userService.queryUserList();
		for (User u : ul) {
			System.out.println(u);
		}
	}
	@Test
	public void  queryUser(){
		User u = userService.queryUser("824@qq.com");
		System.out.println(u);
	}
	@Test
	public void checkUser() {
		System.out.println(userService.checkUser("824@qq.com","123"));
	}
	@Test
	public void addUser(){
		System.out.println(userService.addUser("¡ıŒ∞“’", "865799243@qq.com", "123", "123"));
	}
	@Test
	public void testTime(){
		Date regdateTime = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(regdateTime));
	}
	
}
