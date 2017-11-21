package dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import dao.UserDao;
import utils.db.DBAccess;
import entity.User;

/**
 * @author lwy
 *	用户的数据库处理操作的实现
 */
public class UserDaoImpl implements UserDao {

	 private SqlSession sqlSession = null;
	 private DBAccess dbAccess  = new DBAccess();
	@Override
	public int addUser(User user) {
		try {
			int result = 0;
			sqlSession = dbAccess.getSqlSession();
			result = sqlSession.insert("User.addUser",user);
			sqlSession.commit();
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){sqlSession.close();}
			}
		return 0;
	}

	@Override
	public int modifyUser(User user) {
		try {
			int result = 0;
			sqlSession = dbAccess.getSqlSession();
			result = sqlSession.update("User.updateUser",user);
			sqlSession.commit();
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
		return 0;
	}

	@Override
	public User queryUser(String uemail) {	
		 try {
			 User user = null;
			sqlSession = dbAccess.getSqlSession();
			user = sqlSession.selectOne("User.queryUser",uemail);
			return user;
		 } catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
				}
			}
		 return null;
	}


	@Override
	public List<User> queryUserList() {
		try {
			List<User> userList = new ArrayList<User>();
			sqlSession =dbAccess.getSqlSession();
			userList = sqlSession.selectList("User.queryUserList");
			
			return userList;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){sqlSession.close();}
			}
		return null;
	}

	@Override
	public boolean checkUser(String email, String password) {
		User result = null;
		try {
			sqlSession =dbAccess.getSqlSession();
			User user = new User();
			user.setUemail(email);
			user.setUpassword(password);
			result = sqlSession.selectOne("User.checkUser",user);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		if(result==null){
			return false;
		}else
		return true;
	}

	@Override
	public int modifyPasswordByEmail(String email, String password) {
		try {
			int result = 0;
			sqlSession =dbAccess.getSqlSession();
			User user = new User();
			user.setUemail(email);
			user.setUpassword(password);
			result = sqlSession.update("User.updateUserPasswordByEmail",user);
			sqlSession.commit();
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return 0;
	}

	@Override
	public int queryUserIDByName(String uname) {
		try {
			int result = 0;
			sqlSession = dbAccess.getSqlSession();
			result = sqlSession.selectOne("User.queryUserIDByName", uname);
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return 0;
	}

	@Override
	public User queryUserOne(int uid) {
		try {
			 User user = null;
			sqlSession = dbAccess.getSqlSession();
			user = sqlSession.selectOne("User.queryUserOne",uid);
			return user;
		 } catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
				}
			}
		 return null;
	}
	
	

}
