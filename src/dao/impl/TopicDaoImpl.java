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
			if(sqlSession!=null)sqlSession.close();
		}
		return result;
	}

	@Override
	public List<Topic> queryTopicListByTSID(int tsid) {
		List<Topic> topics = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			topics = sqlSession.selectList("Topic.queryTopicList", tsid);
		} catch (IOException e) {
			e.printStackTrace();
			return topics;
		}finally{
			if(sqlSession!=null)sqlSession.close();
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
		}finally{
			if(sqlSession!=null)sqlSession.close();
		}
		return topic;
	}

	@Override
	public int updateClickCount(String ttopic) {
		int result =0;
		try {
			sqlSession = dbAccess.getSqlSession();
			result = sqlSession.update("Topic.updateClickCount", ttopic);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
			return result;
		}finally{
			if(sqlSession!=null)sqlSession.close();
		}
		return result;
	}

	@Override
	public int updateReplyCountAdd(Topic topic) {
		int result = 0 ;
		try {
			sqlSession = dbAccess.getSqlSession();
			result = sqlSession.update("Topic.updateReplyCountAdd", topic);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
			return result;
		}finally{
			if(sqlSession!=null)sqlSession.close();
		}
		return result;
	}

}
