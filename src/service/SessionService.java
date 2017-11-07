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

	@Override
	public String querySessionNameBySID(int sid) {
		return sdi.querySessionNameBySID(sid);
	}

	@Override
	public boolean updateSessionClickCount(String sname) {
		return sdi.updateSessionClickCount(sname)>0;
	}

	@Override
	public boolean addSessionStopiccount(String sname) {
		
		return sdi.addSessionStopiccount(sname)>0;
	}

	@Override
	public boolean subSessionStopiccount(String sname) {
		return sdi.subSessionStopiccount(sname)>0;
	}

	@Override
	public int querySessionStopicCount(String sname) {
		
		return sdi.querySessionStopicCount(sname);
	}

	
}
