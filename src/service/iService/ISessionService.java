package service.iService;

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
}		
