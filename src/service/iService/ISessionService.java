package service.iService;

import java.util.List;

import entity.Session;

/**
 * @author ��ΰ��
 * session���ӿ�
 */
public interface ISessionService {
	/**
	 * ��ѯ����������Ϣ
	 * @param sname ��������
	 * @return session
	 */
	Session searchSession(String sname);
	/**
	 * ��ѯ���ϵİ���飬����sprofile
	 * @return �����
	 */
	List<Session>querySessionByProfile(String sprofile);
}		
 