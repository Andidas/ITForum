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
	 * ��ѯ�����û�
	 * @param uid
	 * @return
	 */
	public User queryUserOne(String uid);
	/**
	 * ����û��Ƿ����
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean checkUser(String email, String password) ;
	/**
	 * ����û��Ƿ����
	 * @param email
	 * @param password sha_1����֮�������
	 * @return
	 */
	public boolean checkUser_isSha_1(String email, String password);
	/**
	 * �����Ƿ����
	 * @param uname
	 * @return
	 */
	public boolean isNameExist(String uname);
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
	public User updateUser(int uid,String uname,String uhead,String uemail,String usex,String ubirthady,String usatement);
	/**
	 * �����û�
	 * @param name
	 * @param email
	 * @param password
	 * @param ensurePassword
	 * @return 
	 */
	public boolean addUser(String name,String email,String password);
	
	/**
	 * ͨ�������޸�����
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean modifyPasswordByEmail(String email, String password) ;


	
}
