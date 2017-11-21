package dao;

import java.util.List;



import entity.User;
/**
 * 用户的数据库处理操作的接口
 * @author lwy
 *
 */
public interface UserDao {
	
	/**
	 * 通过用户名查找用户id
	 * @param uname
	 * @return uid
	 */
	int queryUserIDByName(String uname);
	/**
	 * 增加用户
	 * @param user 要增加的用户 (uname,upassword,uemail,uregdate)
	 * @return 返回被增加的条数，如果不大于0则表示失败
	 */
	int addUser(User user);
	
	/**
	 * 修改用户
	 * @param user 要修改的用户
	 * @return 返回被更新的条数，如果不大于0则表示失败
	 */
	int modifyUser(User user);
	/**
	 * 查询单个用户
	 * @param uemail 要查询的用户email
	 * @return 查询到得一个用户user(all)
	 */
	User queryUser(String uemail);
	User queryUserOne(int uid);
	/**
	 * 查询所有的用户
	 * @return 用户组
	 */
	List<User> queryUserList();
	
	/**
	 * 检查用户是否存在
	 * @param email 用户名
	 * @param password 密码
	 * @return
	 */
	boolean checkUser(String email,String password);
	
	/**
	 * 通过邮箱修改密码
	 * @param email
	 * @param password
	 * @return
	 */
	int modifyPasswordByEmail(String email,String password);
	
}
