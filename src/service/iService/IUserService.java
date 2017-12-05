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
	 * 查询单个用户
	 * @param uid
	 * @return
	 */
	public User queryUserOne(String uid);
	/**
	 * 检查用户是否存在
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean checkUser(String email, String password) ;
	/**
	 * 检查用户是否存在
	 * @param email
	 * @param password sha_1加密之后的密码
	 * @return
	 */
	public boolean checkUser_isSha_1(String email, String password);
	/**
	 * 名字是否存在
	 * @param uname
	 * @return
	 */
	public boolean isNameExist(String uname);
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
	public User updateUser(int uid,String uname,String uhead,String uemail,String usex,String ubirthady,String usatement);
	/**
	 * 增加用户
	 * @param name
	 * @param email
	 * @param password
	 * @param ensurePassword
	 * @return 
	 */
	public boolean addUser(String name,String email,String password);
	
	/**
	 * 通过邮箱修改密码
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean modifyPasswordByEmail(String email, String password) ;


	
}
