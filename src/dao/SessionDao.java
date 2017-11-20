package dao;

import java.util.List;

import entity.Session;
import entity.viewEntity.SessionView;
/**
 * �������ݿ⴦������Ľӿ�
 * @author lwy
 *
 */
public interface SessionDao {
	/**
	 * ��ѯ���е�session����profile
	 * @return
	 */
	List <String>queryAllProfile();
	/**
	 * ����session��id
	 * @param sname
	 * @return
	 */
	int querySessionID(String sname);
	/**
	 * ����һ��session
	 * @param session
	 * @return
	 */
	int insertSession(Session session);
	/**
	 * ��ѯsession view
	 * @param sid
	 * @return
	 */
	SessionView querySessionView(int sid);
	/**
	 * ��������1
	 * @param sid
	 * @return ����0�ɹ�
	 */
	int addSessionStopiccount(int sid);
	/**
	 * ��������1
	 * @param sname
	 * @return ����0�ɹ�
	 */
	int subSessionStopiccount(String sname);
	/**
	 * ��ѯ������
	 * @param sname
	 * @return �������ӵ���Ŀ
	 */
	int querySessionStopicCount(String sname);
	
	/**
	 * ���������1
	 * @param sname
	 * @return ����0�ɹ�
	 */
	int updateSessionClickCount(int sid);

	
	/**
	 * ��ѯ�������
	 * @param sid Ҫ��ѯ�İ��sid
	 * @return ��ѯ����һ�����Session(all)
	 */
	Session searchSession(int sid);
	/**
	 * ��ѯ���ϵ����ư���飬����sprofile ��sid
	 * ��������������session����
	 * @return �����
	 */
	List<Session> querySameSession(Session session);
	
	/**
	 * ��ѯ����ͬһ���session
	 * @param sprofile
	 * @return
	 */
	List<Session> queryAllSessionByProfile(String sprofile);
	/**
	 * ͨ������������session
	 * @param searchText
	 * @return
	 */
	List<Session> searchSession(String searchText);
	

	
	
}
