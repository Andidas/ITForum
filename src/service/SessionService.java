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
	public Session searchSession(int sid) {
		Session session = null;
		session = sdi.searchSession(sid);
		return session;
	}

	@Override
	public List<Session> querySameSession(Session session) {
		return sdi.querySameSession(session);
	}

	@Override
	public String querySessionNameBySID(int sid) {
		return sdi.querySessionNameBySID(sid);
	}


	@Override
	public boolean subSessionStopiccount(String sname) {
		return sdi.subSessionStopiccount(sname)>0;
	}

	@Override
	public int querySessionStopicCount(String sname) {
		
		return sdi.querySessionStopicCount(sname);
	}
	@Override
	public boolean updateSessionClickCount(String sid) {
		int sessionId = Integer.parseInt(sid);
		return sdi.updateSessionClickCount(sessionId)>0;
	}

	
}
