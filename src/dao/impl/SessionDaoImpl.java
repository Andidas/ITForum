package dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.SessionDao;
import db.DBAccess;
import entity.Session;

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

	
	

}
