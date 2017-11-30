package dao;

import java.util.List;






import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import entity.User;
/**
 * 用户的数据库处理操作的接口
 * @author lwy
 *
 */

public interface UserDao {
	
	/**
	 * 判断用户名是否存在
	 * @param uname
	 * @return uid
	 */
	@Select("select count(uid) uid from user where uname = #{_parameter}")
	int isExistName(String uname);
	/**
	 * 增加用户
	 * @param user 要增加的用户 (uname,upassword,uemail,uregdate)
	 * @return 返回被增加的条数，如果不大于0则表示失败
	 */
	@Insert("INSERT INTO `user` (uname,uemail,upassword,uregdate) VALUES(#{uname},#{uemail},#{upassword},#{uregdate})")
	int addUser(User user);
	
	/**
	 * 修改用户
	 * @param user 要修改的用户
	 * @return 返回被更新的条数，如果不大于0则表示失败
	 */
	@Update(" UPDATE user SET uname = #{uname},upassword = #{upassword},uemail = #{uemail},uregdate = #{uregdate},ubirthady = #{ubirthady},usex = #{usex}, uhead = #{uhead}, usatement = #{usatement},ustate = #{ustate},upoint = #{upoint}, uissectioner = #{uissectioner} WHERE uid = #{uid}")
	int updateUser(User user);
	/**
	 * 查询单个用户
	 * @param uemail 要查询的用户email
	 * @return 查询到得一个用户user(all)
	 */
	@Select("select * from user where uemail = #{_parameter}")
	User queryUserOneByEmail(String uemail);
	/**
	 * 查询单个用户，通过id查询
	 * @param uid
	 * @return
	 */
	@Select("select * from user where uid = #{_parameter}")
	User queryUserOne(int uid);
	/**
	 * 查询所有的用户
	 * @return 用户组
	 */
	@Select("select uid,uname,upassword,uemail,uregdate,ubirthady,usex,uhead,usatement,ustate,upoint,uissectioner from user")
	List<User> queryUserList();
	
	/**
	 * 检查用户是否存在
	 * @param email 用户名
	 * @param password 密码
	 * @return
	 */
	@Select("select count(*) num from user where uemail = #{uemail} and upassword = #{upassword}")
	int checkUser(User user);
	
	/**
	 * 通过邮箱修改密码
	 * @param email
	 * @param password
	 * @return
	 */
	@Update("UPDATE user SET upassword = #{upassword} WHERE uemail = #{uemail}")
	int modifyPasswordByEmail(User user);
	
}
