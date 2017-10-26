package service;

import java.util.List;

import dao.impl.UserDaoImpl;
import entity.User;

public class UserService {

	UserDaoImpl udi = new UserDaoImpl();
	public List<User> queryUserList() {
		return udi.queryUserList();
	}
	public User queryUser(String uemail) {
		return udi.queryUser(uemail);
	}
	public boolean checkUser(String email, String password) {
		return udi.checkUser(email, password);
	}
	
}
