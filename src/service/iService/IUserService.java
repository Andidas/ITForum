package service.iService;

import java.util.List;

import entity.User;
/**
 * @author 刘伟艺
 * 用户服务接口
 */
public interface IUserService {
	
	public List<User> queryUserList();
	/**
	 * 查询单个用户
	 * @param email
	 * @return
	 */
	public User queryUser(String email) ;
	/**
	 * 检查用户是否存在
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean checkUser(String email, String password) ;
	
	/**
	 * 修改用户
	 * @param u 用户
	 * @param uname 要修改的名字
	 * @param uhead
	 * @param uemail
	 * @param usex
	 * @param ubirthady
	 * @param usatement
	 * @return 新的用户信息User
	 */
	public User modifyUser(User u,String uname,String uhead,String uemail,String usex,String ubirthady,String usatement);
	/**
	 * 增加用户
	 * @param name
	 * @param email
	 * @param password
	 * @param ensurePassword
	 * @return result = 1两次输入的密码不同，result = 2插入数据库失败，result = 4新增用户成功并插入数据库，
	 */
	public int addUser(String name,String email,String password,String ensurePassword);
	
}
