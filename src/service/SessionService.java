package service;

import java.util.List;

import dao.SessionDao;
import dao.factory.DaoFactory;
import dao.factory.DaoFactory.EnumDaoFactory;
import entity.Session;
import service.iService.ISessionService;

/**
 * @author ÁõÎ°ÒÕ
 * session°æ¿é
 */
public class SessionService implements ISessionService {
	SessionDao sessionDao = DaoFactory.getInstance(EnumDaoFactory.SESSION).getSessionDao();

	
	@Override
	public Session searchSession(int sid) {
		Session session = null;
		session = sessionDao.searchSession(sid);
		return session;
	}

	@Override
	public List<Session> querySameSession(String sprofile,int sid) {
		Session session = new Session();
		session.setSprofile(sprofile);session.setSid(sid);
		return sessionDao.querySameSession(session);
	}

	@Override
	public boolean subSessionStopiccount(String sname) {
		return sessionDao.subSessionStopiccount(sname)>0;
	}

	@Override
	public int querySessionStopicCount(String sname) {
		
		return sessionDao.querySessionStopicCount(sname);
	}
	@Override
	public boolean updateSessionClickCount(String sid) {
		int sessionId = Integer.parseInt(sid);
		return sessionDao.updateSessionClickCount(sessionId)>0;
	}

	

	
}
