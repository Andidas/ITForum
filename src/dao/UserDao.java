package dao;

import java.util.List;
import java.util.Vector;


import entity.User;
/**
 * �û������ݿ⴦������Ľӿ�
 * @author lwy
 *
 */
public interface UserDao {
	/**
	 * �����û�
	 * @param user Ҫ���ӵ��û� (uname,upassword,uemail,uregdate)
	 * @return ���ر����ӵ����������������0���ʾʧ��
	 */
	int addUser(User user);
	/**
	 * ɾ���û�
	 * @param uemail �û���email
	 * @return ���ر�ɾ�������������������0���ʾʧ��
	 */
	int delUser(String uemail);
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
	/**
	 * ��ѯ���е��û�
	 * @return �û���
	 */
	List<User> queryUserList();
	/**
	 * ��ѯ���е��û�
	 * @return �û���
	 */
	Vector<Vector<Object>> getUserData();
	
	/**
	 * ���ڱ���ͷ
	 * @return
	 */
	Vector<String> getTitles();
	
	
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
