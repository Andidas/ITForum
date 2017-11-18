package service.iService;

import java.util.List;

import entity.Session;

/**
 * @author ��ΰ��
 * session���ӿ�
 */
public interface ISessionService {
	/**
	 * ����session
	 * @param sname
	 * @return
	 */
	int querySessionID(String sname);
	
	/**
	 * ͨ����������ѯ��������
	 * @param searchText
	 * @return
	 */
	List<Session> searchSession(String searchText);
	/**
	 * �Ƿ��ǲ�ѯsession
	 * @param text
	 * @return
	 */
	public boolean isSearchSession(String text);
	/**
	 * ��������1
	 * @param sname
	 * @return �ɹ�,����true
	 */
	boolean subSessionStopiccount(String sname);
	/**
	 * ��ѯ������
	 * @param sname
	 * @return �������ӵ���Ŀ
	 */
	int querySessionStopicCount(String sname);
	/**
	 * ��ѯ����������Ϣ
	 * @param sid ����id
	 * @return session
	 */
	Session searchSession(int sid);
	/**
	 * ��ѯ���ϵİ���飬����sprofile
	 * @param sprofile // session ���⣬��������
	 * @param sid 
	 * @return �����
	 */
	
	List<Session>querySameSession(String sprofile,int sid);
	
	
	/**
	 * ���������1
	 * @param sid
	 * @return
	 */
	boolean updateSessionClickCount(String sid);
	/**
	 * ����session
	 * @param sname
	 * @param smasterid
	 * @param sprofile
	 * @param sstatement
	 * @param spicture
	 * @return
	 */
	boolean addSession(String sname, int smasterid, String sprofile,
			String sstatement, String spicture);
	
}		
 