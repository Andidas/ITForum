package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.TopicDao;
import utils.db.MyBatisSessionFactory;
import entity.PageMode;
import entity.PageParam;
import entity.Topic;
import entity.viewEntity.TopicView;

/**
 * @author lwy
 *
 */
public class TopicDaoImpl implements TopicDao {

	
	@Override
	public int addTopic(Topic topic) {
			int result = 0;
			SqlSession sqlSession = MyBatisSessionFactory.getSession();
			result = sqlSession.insert("Topic.addTopic",topic);
			sqlSession.commit();			
			MyBatisSessionFactory.closeSession();
			return result;
	}

	@Override
	public PageMode<TopicView> splitPage(PageParam page){
		int start = (page.getPageno()-1)*page.getPagesize();
		page.setPageno(start);
		
			PageMode<TopicView> pm = new PageMode<TopicView>();
			List<TopicView> pageData = new ArrayList<TopicView>();
			
			SqlSession sqlSession = MyBatisSessionFactory.getSession();
			pageData = sqlSession.selectList("Topic.splitPage", page);
			
			pm.setData(pageData);
			pm.setPageParam(page);
			pm.setTotalRecordCount(this.rowCount(page.getId()));
		
			MyBatisSessionFactory.closeSession();
			return pm;
	}
	
	//
	@Override
	public PageMode<TopicView> splitPageByReplyCount(PageParam page){
		int start = (page.getPageno()-1)*page.getPagesize();
		page.setPageno(start);
		
			PageMode<TopicView> pm = new PageMode<TopicView>();
			List<TopicView> pageData = new ArrayList<TopicView>();
			
			SqlSession sqlSession = MyBatisSessionFactory.getSession();
			pageData = sqlSession.selectList("Topic.splitPageByReplyCount", page);
			
			pm.setData(pageData);
			pm.setPageParam(page);
			pm.setTotalRecordCount(this.rowCount(page.getId()));
		
			MyBatisSessionFactory.closeSession();
			return pm;
	}
	
	
	
	@Override
	public PageMode<Topic> queryUserAllTopic(PageParam page) {
		int start = (page.getPageno()-1)*page.getPagesize();
		page.setPageno(start);
		
			PageMode<Topic> pm = new PageMode<Topic>();
			List<Topic> pageData = new ArrayList<Topic>();
			
			SqlSession sqlSession = MyBatisSessionFactory.getSession();
			pageData = sqlSession.selectList("Topic.queryUserAllTopic", page);
			
			pm.setData(pageData);
			pm.setPageParam(page);
			pm.setTotalRecordCount(this.rowUserTopicNum(page.getId()));
		
			MyBatisSessionFactory.closeSession();
			return pm;
	
	}
	@Override
	public int rowUserTopicNum(int id){
			int num = 0;
			SqlSession sqlSession = MyBatisSessionFactory.getSession();
			num = sqlSession.selectOne("Topic.rowUserTopicNum", id);
			MyBatisSessionFactory.closeSession();
			return num;
	}
	@Override
	public int rowCount(int id) {
			int num = 0;
			SqlSession sqlSession = MyBatisSessionFactory.getSession();
			num = sqlSession.selectOne("Topic.rowNum", id);
			MyBatisSessionFactory.closeSession();
			return num;
	}
	
	@Override
	public List<Topic> querySameTopicListByTSID(int tsid) {
			List<Topic> topics = null;
			SqlSession sqlSession = MyBatisSessionFactory.getSession();
			topics = sqlSession.selectList("Topic.querySameTopicList", tsid);
			MyBatisSessionFactory.closeSession();
			return topics;
	}

	@Override
	public Topic queryTopicOneByTopic(int tid) {
			Topic topic = null;
			SqlSession sqlSession = MyBatisSessionFactory.getSession();
			topic = sqlSession.selectOne("Topic.queryTopicOneByTopic", tid);
			MyBatisSessionFactory.closeSession();
			return topic;
	}

	@Override
	public int updateClickCount(int tid) {
			int result =0;
			SqlSession sqlSession = MyBatisSessionFactory.getSession();
			result = sqlSession.update("Topic.updateClickCount", tid);
			sqlSession.commit();
			MyBatisSessionFactory.closeSession();
			return result;
	}

	@Override
	public int updateReplyCountAdd(Topic topic) {
			int result = 0 ;
			SqlSession sqlSession = MyBatisSessionFactory.getSession();
			result = sqlSession.update("Topic.updateReplyCountAdd", topic);
			sqlSession.commit();
			MyBatisSessionFactory.closeSession();
			return result;
	}

	public TopicView getTopicViewOne(int tid) {
			TopicView topicView = null;
			SqlSession sqlSession = MyBatisSessionFactory.getSession();
			topicView = sqlSession.selectOne("Topic.topicViewOne", tid);
			MyBatisSessionFactory.closeSession();
			return topicView;
	}

	@Override
	public List<Topic> searchTopicAndContents(String text) {
			List<Topic> topics = null;
			SqlSession sqlSession = MyBatisSessionFactory.getSession();
			topics = sqlSession.selectList("Topic.searchTopicAndContents", text);
			MyBatisSessionFactory.closeSession();
			return topics;
	}

	@Override
	public List<Topic> queryHotsTopicList() {
			List<Topic> topics = null;
			SqlSession sqlSession = MyBatisSessionFactory.getSession();
			topics = sqlSession.selectList("Topic.queryHotsTopicList");
			MyBatisSessionFactory.closeSession();
			return topics;
	}

	@Override
	public int deleteTopic(int tid) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int updateReplyCountSub(int tid) {
		// TODO 自动生成的方法存根
		return 0;
	}


}
