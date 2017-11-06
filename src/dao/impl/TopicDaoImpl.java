package dao.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import utils.DBUtils;
import dao.TopicDao;
import db.DBAccess;
import entity.Topic;

/**
 * @author lwy
 *
 */
public class TopicDaoImpl implements TopicDao {

	private SqlSession sqlSession = null;
	private DBAccess dbAccess = new DBAccess();
	@Override
	public int addTopic(Topic topic) {
		int result = 0;
		try {
			sqlSession = dbAccess.getSqlSession();
			result = sqlSession.insert("Topic.addTopic",topic);
			sqlSession.commit();
			
		} catch (IOException e) {
			return result;
		}finally{
			sqlSession.close();
		}
		return result;
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
	public Topic queryTopic(int tid) {
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

	@Override
	public List<Topic> queryTopicListByTSID(int tsid) {
		List<Topic> topics = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			topics = sqlSession.selectList("Topic.queryTopicList", tsid);
		} catch (IOException e) {
			e.printStackTrace();
			return topics;
		}
		return topics;
	}

	@Override
	public Topic queryTopicOneByTopic(String ttopic) {
		Topic topic = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			topic = sqlSession.selectOne("Topic.queryTopicOneByTopic", ttopic);
		} catch (IOException e) {
			e.printStackTrace();
			return topic;
		}
		return topic;
	}

}
