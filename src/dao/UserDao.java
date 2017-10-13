package dao;

import java.util.Vector;

import entity.User;
/**
 * 用户的数据库处理操作的接口
 * @author andi(刘伟艺)
 *
 */
public interface UserDao {
	/**
	 * 增加用户
	 * @param user 要删除的用户 
	 * @return 返回被增加的条数，如果不大于0则表示失败
	 */
	int addUser(User user);
	/**
	 * 删除用户
	 * @param uid 用户的id
	 * @return 返回被删除的条数，如果不大于0则表示失败
	 */
	int delUser(int uid);
	/**
	 * 修改用户
	 * @param user 要修改的用户
	 * @return 返回被更新的条数，如果不大于0则表示失败
	 */
	int modifyUser(User user);
	/**
	 * 查询单个用户
	 * @param uid 要查询的用户id
	 * @return 查询到得一个用户
	 */
	User searchUser(int uid);
	/**
	 * 查询所有的用户
	 * @return 用户组
	 */
	Vector<Vector<Object>> getUserData();
	
	/**
	 * 用于表格的头
	 * @return
	 */
	Vector<String> getTitles();
}
