package dao;

import java.util.Vector;

import entity.User;
/**
 * �û������ݿ⴦������Ľӿ�
 * @author andi(��ΰ��)
 *
 */
public interface UserDao {
	/**
	 * �����û�
	 * @param user Ҫɾ�����û� 
	 * @return ���ر����ӵ����������������0���ʾʧ��
	 */
	int addUser(User user);
	/**
	 * ɾ���û�
	 * @param uid �û���id
	 * @return ���ر�ɾ�������������������0���ʾʧ��
	 */
	int delUser(int uid);
	/**
	 * �޸��û�
	 * @param user Ҫ�޸ĵ��û�
	 * @return ���ر����µ����������������0���ʾʧ��
	 */
	int modifyUser(User user);
	/**
	 * ��ѯ�����û�
	 * @param uid Ҫ��ѯ���û�id
	 * @return ��ѯ����һ���û�
	 */
	User searchUser(int uid);
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
}
