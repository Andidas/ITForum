package service;

import java.util.List;

import service.iService.ISessionService;
import utils.ConstantsData.EnumDaoFactory;
import dao.SessionDao;
import dao.factory.DaoFactory;
import entity.Session;

/**
 * @author ÁõÎ°ÒÕ
 * session°æ¿é
 */
public class SessionService implements ISessionService {
	SessionDao sessionDao = DaoFactory.getInstance(EnumDaoFactory.SESSION).getSessionDao();

	@Override
	public boolean isSearchSession(String text){
		if(!text.equals("")&&text.length()>2){
			char [] t = text.toCharArray();
			int first = t[0];
			int last = t[t.length-1];
			if(first==91&&last==93){
				return true;
			}
		}
		return false;
	}
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
	@Override
	public List<Session> searchSession(String searchText) {
		String Text = searchText.substring(1,searchText.length()-1);
		return sessionDao.searchSession(Text);
	}
	@Override
	public boolean addSession(String sname, int smasterid, String sprofile,
			String sstatement, String spicture) {
		Session session = new Session();
		session.setSname(sname);
		session.setSmasterid(smasterid);
		session.setSprofile(sprofile);session.setSstatement(sstatement);
		session.setSpicture(spicture);
		return sessionDao.insertSession(session)>0;
	}
	@Override
	public int querySessionID(String sname) {
		return sessionDao.querySessionID(sname);
	}

	

	
}
