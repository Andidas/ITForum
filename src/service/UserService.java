package service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	/**
	 * @param name
	 * @param email
	 * @param password
	 * @param ensurePassword
	 * @return result = 1两次输入的密码不同，result = 2插入数据库失败，result = 4新增用户成功并插入数据库，
	 */
	public int addUser(String name,String email,String password,String ensurePassword) {
		int result = 1;
		if(password.equals(ensurePassword)){//校验两次密码是否相同			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String regdateTime = df.format(new Date());//获取注册时间
			User user = new User();
			user.setUname(name);
			user.setUemail(email);
			user.setUpassword(password);
			user.setUregdate(regdateTime);
			if(udi.addUser(user)>0){
				result = 4;
			}else{
				result = 2;
			}
		}
		return result;
		
		
		
	}
	
}
