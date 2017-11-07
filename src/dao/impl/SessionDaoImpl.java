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
	public Session searchSession(String sname) {
		Session session = null;
		try {
			sqlSession  = dbAccess.getSqlSession();
			session = sqlSession.selectOne("Session.querySession",sname);
		} catch (IOException e) {
			return session;
		}finally{
			sqlSession.close();
		}
		return session;
	}

	public int querySessionIDByName(String sname) {
		int result =0;
		try {
			sqlSession  = dbAccess.getSqlSession();
			result = sqlSession.selectOne("Session.querySessionIDByName",sname);
		} catch (IOException e) {
			return result;
		}finally{
			sqlSession.close();
		}
		return result;
	}

	@Override
	public List<Session> querySessionByProfile(String sprofile) {
		 List<Session> sessionList = null;
		 try {
				sqlSession  = dbAccess.getSqlSession();
				sessionList = sqlSession.selectList("Session.querySessionByProfile",sprofile);
			} catch (IOException e) {
				return sessionList;
			}finally{
				sqlSession.close();
			}
		return sessionList;
	}

	@Override
	public String querySessionNameBySID(int sid) {
		String sname = null;
		 try {
				sqlSession  = dbAccess.getSqlSession();
				sname = sqlSession.selectOne("Session.querySessionNameBySID",sid);
			} catch (IOException e) {
				return sname;
			}finally{
				sqlSession.close();
			}
		return sname;
	}

	@Override
	public int updateSessionClickCount(String sname) {
		int result = 0;
		 try {
				sqlSession  = dbAccess.getSqlSession();
				result = sqlSession.update("Session.updateSessionClickCount",sname);
				sqlSession.commit();
			} catch (IOException e) {
				return result;
			}finally{
				sqlSession.close();
			}
		return result;
	}

	@Override
	public int addSessionStopiccount(String sname) {
		int result = 0;
		 try {
				sqlSession  = dbAccess.getSqlSession();
				result = sqlSession.update("Session.addSessionStopiccount",sname);
				sqlSession.commit();
			} catch (IOException e) {
				return result;
			}finally{
				sqlSession.close();
			}
		return result;
	}

	@Override
	public int subSessionStopiccount(String sname) {
		int result = 0;
		 try {
			 if(querySessionStopicCount(sname)>0){
				 sqlSession  = dbAccess.getSqlSession();
				 result = sqlSession.update("Session.addSessionStopiccount",sname);
				 sqlSession.commit();				 
			 }
			} catch (IOException e) {
				return result;
			}finally{
				sqlSession.close();
			}
		return result;
	}

	@Override
	public int querySessionStopicCount(String sname) {
		int result = 0;
		 try {
				sqlSession  = dbAccess.getSqlSession();
				result = sqlSession.selectOne("Session.querySessionStopicCount",sname);
				
			} catch (IOException e) {
				return result;
			}finally{
				sqlSession.close();
			}
		return result;
	}

}
