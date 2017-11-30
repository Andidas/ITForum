package dao;

import java.util.List;






import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import entity.User;
/**
 * �û������ݿ⴦������Ľӿ�
 * @author lwy
 *
 */

public interface UserDao {
	
	/**
	 * �ж��û����Ƿ����
	 * @param uname
	 * @return uid
	 */
	@Select("select count(uid) uid from user where uname = #{_parameter}")
	int isExistName(String uname);
	/**
	 * �����û�
	 * @param user Ҫ���ӵ��û� (uname,upassword,uemail,uregdate)
	 * @return ���ر����ӵ����������������0���ʾʧ��
	 */
	@Insert("INSERT INTO `user` (uname,uemail,upassword,uregdate) VALUES(#{uname},#{uemail},#{upassword},#{uregdate})")
	int addUser(User user);
	
	/**
	 * �޸��û�
	 * @param user Ҫ�޸ĵ��û�
	 * @return ���ر����µ����������������0���ʾʧ��
	 */
	@Update(" UPDATE user SET uname = #{uname},upassword = #{upassword},uemail = #{uemail},uregdate = #{uregdate},ubirthady = #{ubirthady},usex = #{usex}, uhead = #{uhead}, usatement = #{usatement},ustate = #{ustate},upoint = #{upoint}, uissectioner = #{uissectioner} WHERE uid = #{uid}")
	int updateUser(User user);
	/**
	 * ��ѯ�����û�
	 * @param uemail Ҫ��ѯ���û�email
	 * @return ��ѯ����һ���û�user(all)
	 */
	@Select("select * from user where uemail = #{_parameter}")
	User queryUserOneByEmail(String uemail);
	/**
	 * ��ѯ�����û���ͨ��id��ѯ
	 * @param uid
	 * @return
	 */
	@Select("select * from user where uid = #{_parameter}")
	User queryUserOne(int uid);
	/**
	 * ��ѯ���е��û�
	 * @return �û���
	 */
	@Select("select uid,uname,upassword,uemail,uregdate,ubirthady,usex,uhead,usatement,ustate,upoint,uissectioner from user")
	List<User> queryUserList();
	
	/**
	 * ����û��Ƿ����
	 * @param email �û���
	 * @param password ����
	 * @return
	 */
	@Select("select count(*) num from user where uemail = #{uemail} and upassword = #{upassword}")
	int checkUser(User user);
	
	/**
	 * ͨ�������޸�����
	 * @param email
	 * @param password
	 * @return
	 */
	@Update("UPDATE user SET upassword = #{upassword} WHERE uemail = #{uemail}")
	int modifyPasswordByEmail(User user);
	
}
