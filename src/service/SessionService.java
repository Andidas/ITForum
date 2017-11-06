package service;

import java.util.List;

import dao.impl.SessionDaoImpl;
import entity.Session;
import service.iService.ISessionService;

/**
 * @author ÁõÎ°ÒÕ
 * session°æ¿é
 */
public class SessionService implements ISessionService {
	SessionDaoImpl sdi = new SessionDaoImpl();

	@Override
	public Session searchSession(String sname) {
		Session session = null;
		session = sdi.searchSession(sname);
		return session;
	}

	@Override
	public List<Session> querySessionByProfile(String sprofile) {
		
		return sdi.querySessionByProfile(sprofile);
	}
}
