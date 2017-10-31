package service.iService;

import java.util.List;

import entity.User;
/**
 * @author ��ΰ��
 * �û�����ӿ�
 */
public interface IUserService {
	
	public List<User> queryUserList();
	/**
	 * ��ѯ�����û�
	 * @param email
	 * @return
	 */
	public User queryUser(String email) ;
	/**
	 * ����û��Ƿ����
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean checkUser(String email, String password) ;
	
	/**
	 * �޸��û�
	 * @param u �û�
	 * @param uname Ҫ�޸ĵ�����
	 * @param uhead
	 * @param uemail
	 * @param usex
	 * @param ubirthady
	 * @param usatement
	 * @return �µ��û���ϢUser
	 */
	public User modifyUser(User u,String uname,String uhead,String uemail,String usex,String ubirthady,String usatement);
	/**
	 * �����û�
	 * @param name
	 * @param email
	 * @param password
	 * @param ensurePassword
	 * @return result = 1������������벻ͬ��result = 2�������ݿ�ʧ�ܣ�result = 4�����û��ɹ����������ݿ⣬
	 */
	public int addUser(String name,String email,String password,String ensurePassword);
	
}
