package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import utils.DBUtils;
import dao.SessionDao;
import entity.Session;

/**
 * @author lwy
 *
 */
public class SessionDaoImpl implements SessionDao {

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
		String sql = "select * from session where sname =?";
		ResultSet rs = DBUtils.doQuery(sql, sname);
		Session session = null;
		if (rs != null) {
			try {
				rs.next();
				session = new Session(rs.getInt("sid"), rs.getString("sname"),
						rs.getInt("smasterid"), rs.getString("sprofile"),
						rs.getString("sstatement"), rs.getInt("stopiccount"),
						rs.getInt("sclickcount"));
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					DBUtils.close(rs.getStatement().getConnection(),
							rs.getStatement(), rs);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.err.println("sname无效，查找不到数据");
		}
		return session;
	}

}
