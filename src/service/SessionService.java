package service;

import dao.impl.SessionDaoImpl;
import entity.Session;
import service.iService.ISessionService;

/**
 * @author ��ΰ��
 * session���
 */
public class SessionService implements ISessionService {
	SessionDaoImpl sdi = new SessionDaoImpl();

	@Override
	public Session searchSession(String sname) {
		Session session = null;
		session = sdi.searchSession(sname);
		return session;
	}
}
