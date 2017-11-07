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
	 * @param sname
	 * @return ����0�ɹ�
	 */
	int addSessionStopiccount(String sname);
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
	int updateSessionClickCount(String sname);
	/**
	 * ͨ��sid����sname
	 * @param sid
	 * @return 
	 */
	String querySessionNameBySID(int sid);
	/**
	 * ͨ��session���õ�sid
	 * @param sname
	 * @return sid
	 */
	int querySessionIDByName(String sname);
	
	/**
	 * ��ѯ�������
	 * @param sname Ҫ��ѯ�İ��name
	 * @return ��ѯ����һ�����Session(all)
	 */
	Session searchSession(String sname);
	/**
	 * ��ѯ���ϵİ���飬����sprofile
	 * @return �����
	 */
	List<Session> querySessionByProfile(String sprofile);
}
