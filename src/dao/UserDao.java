package dao;

import java.util.List;



import entity.User;
/**
 * �û������ݿ⴦������Ľӿ�
 * @author lwy
 *
 */
public interface UserDao {
	
	/**
	 * ͨ���û��������û�id
	 * @param uname
	 * @return uid
	 */
	int queryUserIDByName(String uname);
	/**
	 * �����û�
	 * @param user Ҫ���ӵ��û� (uname,upassword,uemail,uregdate)
	 * @return ���ر����ӵ����������������0���ʾʧ��
	 */
	int addUser(User user);
	
	/**
	 * �޸��û�
	 * @param user Ҫ�޸ĵ��û�
	 * @return ���ر����µ����������������0���ʾʧ��
	 */
	int modifyUser(User user);
	/**
	 * ��ѯ�����û�
	 * @param uemail Ҫ��ѯ���û�email
	 * @return ��ѯ����һ���û�user(all)
	 */
	User queryUser(String uemail);
	User queryUserOne(int uid);
	/**
	 * ��ѯ���е��û�
	 * @return �û���
	 */
	List<User> queryUserList();
	
	/**
	 * ����û��Ƿ����
	 * @param email �û���
	 * @param password ����
	 * @return
	 */
	boolean checkUser(String email,String password);
	
	/**
	 * ͨ�������޸�����
	 * @param email
	 * @param password
	 * @return
	 */
	int modifyPasswordByEmail(String email,String password);
	
}
