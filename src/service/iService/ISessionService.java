package service.iService;

import java.util.List;

import entity.Session;
import entity.viewEntity.SessionView;

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
	
}		
 