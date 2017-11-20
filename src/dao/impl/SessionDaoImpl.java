package dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.SessionDao;
import utils.db.DBAccess;
import entity.Session;
import entity.viewEntity.SessionView;

/**
 * @author lwy
 *
 */
public class SessionDaoImpl implements SessionDao {
	 private SqlSession sqlSession = null;
	 private DBAccess dbAccess  = new DBAccess();

	
	@Override
	public Session searchSession(int sid) {
		try {
			Session session = null;
			sqlSession  = dbAccess.getSqlSession();
			session = sqlSession.selectOne("Session.querySessionBySid",sid);
			return session;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return null;
		
	}


	@Override
	public List<Session> querySameSession(Session session) {
		 try {
			 List<Session> sessionList = null;
				sqlSession  = dbAccess.getSqlSession();
				sessionList = sqlSession.selectList("Session.querySameSession",session);
				return sessionList;
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				sqlSession.close();
			}
		return null;
	}


	
	@Override
	public int updateSessionClickCount(int sid) {
		try {
			 int result = 0;
				sqlSession  = dbAccess.getSqlSession();
				result = sqlSession.update("Session.updateSessionClickCountBySid",sid);
				sqlSession.commit();
				return result;
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				sqlSession.close();
			}
		return 0;
	}
	@Override
	public int addSessionStopiccount(int sid) {
		 try {
			 int result = 0;
				sqlSession  = dbAccess.getSqlSession();
				result = sqlSession.update("Session.addSessionStopiccount",sid);
				sqlSession.commit();
				return result;
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				sqlSession.close();
			}
		return 0;
	}

	@Override
	public int subSessionStopiccount(String sname) {
		 try {
			 int result = 0;
			 if(querySessionStopicCount(sname)>0){
				 sqlSession  = dbAccess.getSqlSession();
				 result = sqlSession.update("Session.addSessionStopiccount",sname);
				 sqlSession.commit();				 
				 return result;
			 }
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				sqlSession.close();
			}
		return 0;
	}

	@Override
	public int querySessionStopicCount(String sname) {
		 try {
			 int result = 0;
				sqlSession  = dbAccess.getSqlSession();
				result = sqlSession.selectOne("Session.querySessionStopicCount",sname);
				
				return result;
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				sqlSession.close();
			}
		return 0;
	}


	@Override
	public SessionView querySessionView(int sid) {
		try {
			SessionView sessionView = new SessionView();
				sqlSession  = dbAccess.getSqlSession();
				sessionView = sqlSession.selectOne("Session.querySessionView",sid);
				
				return sessionView;
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				sqlSession.close();
			}
		return null;
	}


	@Override
	public List<Session> searchSession(String searchText) {
		 try {
			 List<Session> sessionList = null;
				sqlSession  = dbAccess.getSqlSession();
				sessionList = sqlSession.selectList("Session.searchSession",searchText);
				return sessionList;
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				sqlSession.close();
			}
		return null;
	}


	@Override
	public int insertSession(Session session) {
		 try {
			 int result = 0;
				sqlSession  = dbAccess.getSqlSession();
				result = sqlSession.insert("Session.insertSession",session);
				sqlSession.commit();
				return result;
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				sqlSession.close();
			}
		return 0;
	}


	@Override
	public int querySessionID(String sname) {
		 try {
			 int result = 0;
				sqlSession  = dbAccess.getSqlSession();
				result = sqlSession.selectOne("Session.querySessionID",sname);
				
				return result;
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				sqlSession.close();
			}
		return 0;
	}


	@Override
	public List<String> queryAllProfile() {
		 try {
			 List<String> profiles = null;
				sqlSession  = dbAccess.getSqlSession();
				profiles = sqlSession.selectList("Session.queryAllProfile");
				return profiles;
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				sqlSession.close();
			}
		return null;
	}


	@Override
	public List<Session> queryAllSessionByProfile(String sprofile) {
		try {
			 List<Session> sessionList = null;
				sqlSession  = dbAccess.getSqlSession();
				sessionList = sqlSession.selectList("Session.queryAllSessionByProfile",sprofile);
				return sessionList;
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				sqlSession.close();
			}
		return null;
	}

	
	

}
