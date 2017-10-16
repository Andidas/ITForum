package dao;

import entity.Session;
/**
 * �������ݿ⴦������Ľӿ�
 * @author lwy
 *
 */
public interface SessionDao {
	/**
	 * ���Ӱ��
	 * @param Session Ҫ���ӵİ�� (sname,smasterid)
	 * @return ���ر����ӵ����������������0���ʾʧ��
	 */
	int addSession(Session Session);
	/**
	 * ɾ�����
	 * @param sid ����id
	 * @return ���ر�ɾ�������������������0���ʾʧ��
	 */
	int delSession(String sname);
	/**
	 * �޸İ��
	 * @param Session Ҫ�޸ĵİ��
	 * @return ���ر����µ����������������0���ʾʧ��
	 */
	int modifySession(Session Session);
	/**
	 * ��ѯ�������
	 * @param sname Ҫ��ѯ�İ��name
	 * @return ��ѯ����һ�����Session(all)
	 */
	Session searchSession(String sname);
	/**
	 * ��ѯ���еİ��
	 * @return �����
	 */
}
