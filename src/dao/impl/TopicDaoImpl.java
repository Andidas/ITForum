package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import utils.DBUtils;
import dao.TopicDao;
import entity.Topic;

public class TopicDaoImpl implements TopicDao {

	@Override
	public int addTopic(Topic topic) {
		String sql = "insert into topic(tid,tsid,tuid,ttopic,tcontents,ttime) values(NULL,?,?,?,?,?)";
		return DBUtils
				.doUpdate(sql, topic.getTsid(),topic.getTuid(),topic.getTtopic(),topic.getTcontents(),topic.getTtime());
	}

	@Override
	public int delTopic(int tid) {
		String sql = "delete from topic where tid = ?";
		return DBUtils.doUpdate(sql, tid);
	}

	@Override
	public int modifyTopic(Topic topic) {
		String sql = "update topic set treplycount=?,temotion=?,ttopic=?,tcontents=?,ttime=?,tclickcount=?,tflag=?,tlastreplyuseid=?,tlastreplaytime=? where tid =?;";
		return DBUtils.doUpdate(sql, topic.getTreplycount(),
				topic.getTemotion(), topic.getTtopic(),
				topic.getTcontents(), topic.getTtime(),
				topic.getTclickcount(),topic.getTflag(), topic.getTlastreplyuseid(),
				topic.getTlastreplaytime(), topic.getTid());
		}

	@Override
	public Topic searchTopic(int tid) {
		String sql = "select * from topic where tid =?";
		ResultSet rs = DBUtils.doQuery(sql, tid);
		Topic topic = null;
		if (rs != null) {
			try {
				rs.next();
				topic=new Topic(rs.getInt("tid"), rs.getInt("tsid"), rs.getInt("tuid"),rs.getInt("treplycount"),rs.getString("temotion"),
						rs.getString("ttopic"),rs.getString("tcontents"), rs.getString("ttime"),rs.getInt("tclickcount"),
						rs.getInt("tflag"),rs.getInt("tlastreplyuseid"),rs.getString("tlastreplaytime"));
				topic = new Topic();
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
			System.err.println("tid无效，查找不到数据");
		}
		return topic;}

}
