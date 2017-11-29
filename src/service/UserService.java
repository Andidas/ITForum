package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import dao.UserDao;
import service.iService.IUserService;
import utils.db.MyBatisSessionFactory;
import entity.User;

/**
 * @author 刘伟艺
 * 用户服务接口实现
 */
public class UserService implements IUserService{
	@Override
	public List<User> queryUserList() {
		SqlSession session = MyBatisSessionFactory.getSession();
		List<User> users = session.getMapper(UserDao.class).queryUserList();
		MyBatisSessionFactory.closeSession();
		return users;
	}
	@Override
	public User queryUser(String email) {
		SqlSession session = MyBatisSessionFactory.getSession();
		User user = session.getMapper(UserDao.class).queryUserOneByEmail(email);
		MyBatisSessionFactory.closeSession();
		return user;
	}
	@Override
	public boolean checkUser(String email, String password) {
		SqlSession session = MyBatisSessionFactory.getSession();
		User user = new User();
		user.setUemail(email);
		user.setUpassword(password);
		int result = session.getMapper(UserDao.class).checkUser(user);
		MyBatisSessionFactory.closeSession();
		return result>0;
	}
	@Override
	public User updateUser(int uid,String uname,String uhead,String uemail,String usex,String ubirthady,String usatement){
		SqlSession session = MyBatisSessionFactory.getSession();
		User user = session.getMapper(UserDao.class).queryUserOne(uid);
		user.setUid(uid);user.setUname(uname);
		user.setUhead(uhead);user.setUemail(uemail);
		user.setUsex(Integer.parseInt(usex));user.setUbirthady(ubirthady);
		user.setUsatement(usatement);
		int result = session.getMapper(UserDao.class).updateUser(user);
		session.commit();
		MyBatisSessionFactory.closeSession();
		if(result>0){
			return user;			
		}
		return null;
	}
	@Override
	public boolean addUser(String name,String email,String password) {
		SqlSession session = MyBatisSessionFactory.getSession();	
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String regdateTime = df.format(new Date());//获取注册时间
		User user = new User();
		user.setUname(name);
		user.setUemail(email);
		user.setUpassword(password);
		user.setUregdate(regdateTime);
		int result = session.getMapper(UserDao.class).addUser(user);
		session.commit();
		MyBatisSessionFactory.closeSession();
		
		return result>0;
	}
	@Override
	public boolean modifyPasswordByEmail(String email, String password) {
		User user = new User();
		user.setUemail(email);
		user.setUpassword(password);
		SqlSession session = MyBatisSessionFactory.getSession();
		int result = session.getMapper(UserDao.class).modifyPasswordByEmail(user);
		session.commit();
		MyBatisSessionFactory.closeSession();	
		return result > 0;
	}
	@Override
	public boolean isNameExist(String uname) {
		SqlSession session = MyBatisSessionFactory.getSession();
		int result = session.getMapper(UserDao.class).isExistName(uname);
		MyBatisSessionFactory.closeSession();
		return result>0;
	}
	@Override
	public User queryUserOne(String uid) {
		int id = Integer.parseInt(uid);
		SqlSession session = MyBatisSessionFactory.getSession();
		User user = session.getMapper(UserDao.class).queryUserOne(id);
		MyBatisSessionFactory.closeSession();
		return user;
	}
	
	
}
