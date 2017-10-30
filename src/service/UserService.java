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
	public User queryUser(String email) {
		return udi.queryUser(email);
	}
	public boolean checkUser(String email, String password) {
		return udi.checkUser(email, password);
	}
	public User modifyUser(User u,String uname,String uhead,String uemail,String usex,String ubirthady,String usatement){
		User user = null;
		try {
			user = (User) u.clone();//ǳ��¡
			if(!uname.equals("")&&uname!=null)user.setUname(uname);
			if(!uname.equals("")&&uname!=null)user.setUsex(Integer.parseInt(usex));
			if(!uhead.equals("")&&uname!=null)user.setUhead(uhead);
			if(!uemail.equals("")&&uname!=null)user.setUemail(uemail);
			if(!ubirthady.equals("")&&uname!=null)user.setUbirthady(ubirthady);
			if(!usatement.equals("")&&uname!=null)user.setUsatement(usatement);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		if(udi.modifyUser(user)>0){
			return user;			
		}
		return null;
	}
	/**
	 * @param name
	 * @param email
	 * @param password
	 * @param ensurePassword
	 * @return result = 1������������벻ͬ��result = 2�������ݿ�ʧ�ܣ�result = 4�����û��ɹ����������ݿ⣬
	 */
	public int addUser(String name,String email,String password,String ensurePassword) {
		int result = 1;
		if(password.equals(ensurePassword)){//У�����������Ƿ���ͬ			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String regdateTime = df.format(new Date());//��ȡע��ʱ��
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
