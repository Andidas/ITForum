package dao.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import utils.DBUtils;
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
	public int addSession(Session session) {
		String sql = "insert into session(sid,sname,smasterid) values(NULL,?,?)";
		return DBUtils
				.doUpdate(sql, session.getSname(), session.getSmasterid());
	}

	@Override
	public int delSession(String sname) {
		String sql = "delete from session where sname = ?";
		return DBUtils.doUpdate(sql, sname);
	}

	@Override
	public int modifySession(Session session) {
		String sql = "update session set smasterid=?,sprofile=?,sstatement=?,stopiccount=?,sclickcount=? where sid =?;";
		return DBUtils.doUpdate(sql, session.getSmasterid(),
				session.getSprofile(), session.getSstatement(),
				session.getStopiccount(), session.getSclickcount(),
				session.getSid());
	}

	@Override
	public Session searchSession(String sname) {
		Session session = null;
		try {
			sqlSession  = dbAccess.getSqlSession();
			session = sqlSession.selectOne("Session.querySession",sname);
		} catch (IOException e) {
			return session;
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
			}
		return sname;
	}

}
