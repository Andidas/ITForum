package dao.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		
		return null;
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

}
