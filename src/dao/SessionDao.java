package dao;

import java.util.List;

import entity.Session;
/**
 * �������ݿ⴦������Ľӿ�
 * @author lwy
 *
 */
public interface SessionDao {
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
	
	
}
