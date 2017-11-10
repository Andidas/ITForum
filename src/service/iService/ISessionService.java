package service.iService;

import java.util.List;

import entity.Session;

/**
 * @author ��ΰ��
 * session���ӿ�
 */
public interface ISessionService {
	
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
	 * @return �����
	 */
	List<Session>querySameSession(Session session);
	
	/**
	 * ͨ��sid����sname
	 * @param sid
	 * @return
	 */
	String querySessionNameBySID(int sid);
	/**
	 * ���������1
	 * @param sid
	 * @return
	 */
	boolean updateSessionClickCount(String sid);
	
}		
 