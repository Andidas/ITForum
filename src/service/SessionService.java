package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import service.iService.ISessionService;
import utils.db.MyBatisSessionFactory;
import utils.sensitive_word.SensitivewordFilter;
import dao.SessionDao;
import entity.Session;


/**
 * @author lwy
 *
 */
public class SessionService implements ISessionService {
	private SensitivewordFilter filter = new SensitivewordFilter();
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
		SqlSession sqlsession = MyBatisSessionFactory.getSession();
		Session session = sqlsession.getMapper(SessionDao.class).searchSessionBySid(sid);
		MyBatisSessionFactory.closeSession();
		return session;
	}

	@Override
	public List<Session> querySameSession(String sprofile,int sid) {
		SqlSession sqlsession = MyBatisSessionFactory.getSession();
		Session session = new Session();
		session.setSprofile(sprofile);
		session.setSid(sid);
		List<Session> sessions = sqlsession.getMapper(SessionDao.class).querySameSession(session);
		MyBatisSessionFactory.closeSession();
		return sessions;
	}

	@Override
	public boolean subSessionStopiccount(String sname) {
		SqlSession sqlsession = MyBatisSessionFactory.getSession();
		int result = sqlsession.getMapper(SessionDao.class).subSessionStopiccount(sname);
		sqlsession.commit();
		MyBatisSessionFactory.closeSession();
		return result>0;
	}

	@Override
	public int querySessionStopicCount(String sname) {
		SqlSession sqlsession = MyBatisSessionFactory.getSession();
		int result = sqlsession.getMapper(SessionDao.class).querySessionStopicCount(sname);
		MyBatisSessionFactory.closeSession();
		return result;
	}
	@Override
	public boolean updateSessionClickCount(String sid) {
		SqlSession sqlsession = MyBatisSessionFactory.getSession();
		int result = sqlsession.getMapper(SessionDao.class).updateSessionClickCount(sid);
		sqlsession.commit();
		MyBatisSessionFactory.closeSession();
		return result>0;
	}
	@Override
	public List<Session> searchSession(String searchText) {
		SqlSession sqlsession = MyBatisSessionFactory.getSession();
		String Text = searchText.substring(1,searchText.length()-1);
		List<Session> sessions = sqlsession.getMapper(SessionDao.class).searchSession(Text);
		MyBatisSessionFactory.closeSession();
		return sessions;
	}
	@Override
	public boolean addSession(String sname, int smasterid, String sprofile,
			String sstatement, String spicture) {
		String statement = filter.replaceSensitiveWord(sstatement, 1, "*");
		SqlSession sqlsession = MyBatisSessionFactory.getSession();
		Session session = new Session();
		session.setSname(sname);
		session.setSmasterid(smasterid);
		session.setSprofile(sprofile);session.setSstatement(statement);
		session.setSpicture(spicture);
		int result = sqlsession.getMapper(SessionDao.class).insertSession(session);
		sqlsession.commit();
		MyBatisSessionFactory.closeSession();
		return result>0;
	}
	@Override
	public int querySessionID(String sname) {
		SqlSession sqlsession = MyBatisSessionFactory.getSession();
		int result = sqlsession.getMapper(SessionDao.class).querySessionID(sname);
		MyBatisSessionFactory.closeSession();
		return result;
	}
	@Override
	public List<String> queryAllProfile() {
		SqlSession sqlsession = MyBatisSessionFactory.getSession();
		List<String> lists = sqlsession.getMapper(SessionDao.class).queryAllProfile();
		MyBatisSessionFactory.closeSession();
		return lists;
	}
	@Override
	public List<Session> queryAllSessionByProfile(String sprofile) {
		SqlSession sqlsession = MyBatisSessionFactory.getSession();
		List<Session> sessions = sqlsession.getMapper(SessionDao.class).queryAllSessionByProfile(sprofile);
		MyBatisSessionFactory.closeSession();
		return sessions;
	}
}
