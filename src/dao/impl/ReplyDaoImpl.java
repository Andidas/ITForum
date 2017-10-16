package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import utils.DBUtils;
import dao.ReplyDao;
import entity.Reply;

/**
 * @author lwy
 *
 */
public class ReplyDaoImpl implements ReplyDao {

	@Override
	public int addReply(Reply reply) {
		String sql = "insert into reply(rid,rtid,rsid,ruid,rcontent,rtime) values(NULL,?,?,?,?,?)";
		return DBUtils
				.doUpdate(sql, reply.getRid(), reply.getRtid(),reply.getRsid(),reply.getRuid(),reply.getRcontent(),reply.getRtime());
	}

	@Override
	public int delReply(int rid) {
		String sql = "delete from reply where rid = ?";
		return DBUtils.doUpdate(sql, rid);
	}

	@Override
	public int modifyReply(Reply reply) {
		String sql = "update reply set rtid=?,rsid=?,ruid=?,rcontent=?,rtime=? where rid =?;";
		return DBUtils.doUpdate(sql, reply.getRtime(),
				reply.getRsid(), reply.getRuid(),
				reply.getRcontent(), reply.getRtime(),
				reply.getRid());
	}

	@Override
	public Reply searchReply(int rid) {
		String sql = "select * from reply where sname =?";
		ResultSet rs = DBUtils.doQuery(sql, rid);
		Reply reply = null;
		if (rs != null) {
			try {
				rs.next();
				reply = new Reply(rs.getInt("rid"),rs.getInt("rtid"),rs.getInt("rsid"),rs.getInt("ruid"),rs.getString("temotion"),
						rs.getString("rcontent"),rs.getString("rtime"));
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
			System.err.println("rid无效，查找不到数据");
		}
		return reply;
	}

}
