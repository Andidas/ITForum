package dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.TopicDao;
import db.DBAccess;
import entity.PageMode;
import entity.PageParam;
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
		try {
			int result = 0;
			sqlSession = dbAccess.getSqlSession();
			result = sqlSession.insert("Topic.addTopic",topic);
			sqlSession.commit();			
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null)sqlSession.close();
		}
		return 0;
	}

	//∑÷“≥≤‚ ‘
	public PageMode<Topic> splitPage(PageParam page){
		int start = (page.getPageno()-1)*page.getPagesize();
		page.setPageno(start);
		try {
			PageMode<Topic> pm = new PageMode<Topic>();
			List<Topic> pageData = new ArrayList<Topic>();
			sqlSession = dbAccess.getSqlSession();
			pageData = sqlSession.selectList("Topic.splitPage", page);
			pm.setData(pageData);
			pm.setPageParam(page);
			pm.setTotalRecordCount(this.rowCount(page.getId()));
			return pm;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null)sqlSession.close();
		}
		return null;
	}
	
	public int rowCount(int id) {
		try {
			int num = 0;
			sqlSession = dbAccess.getSqlSession();
			num = sqlSession.selectOne("Topic.rowNum", id);
			return num;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Topic> queryTopicListByTSID(int tsid) {
		try {
			List<Topic> topics = null;
			sqlSession = dbAccess.getSqlSession();
			topics = sqlSession.selectList("Topic.queryTopicList", tsid);
			return topics;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null)sqlSession.close();
		}
		return null;
	}

	@Override
	public Topic queryTopicOneByTopic(String ttopic) {
		try {
			Topic topic = null;
			sqlSession = dbAccess.getSqlSession();
			topic = sqlSession.selectOne("Topic.queryTopicOneByTopic", ttopic);
			return topic;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null)sqlSession.close();
		}
		return null;
	}

	@Override
	public int updateClickCount(String ttopic) {
		try {
			int result =0;
			sqlSession = dbAccess.getSqlSession();
			result = sqlSession.update("Topic.updateClickCount", ttopic);
			sqlSession.commit();
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null)sqlSession.close();
		}
		return 0;
	}

	@Override
	public int updateReplyCountAdd(Topic topic) {
		try {
			int result = 0 ;
			sqlSession = dbAccess.getSqlSession();
			result = sqlSession.update("Topic.updateReplyCountAdd", topic);
			sqlSession.commit();
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null)sqlSession.close();
		}
		return 0;
	}

}
