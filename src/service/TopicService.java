package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import service.iService.ITopicService;
import utils.db.MyBatisSessionFactory;
import utils.sensitive_word.SensitivewordFilter;
import dao.SessionDao;
import dao.TopicDao;
import dao.impl.TopicDaoImpl;
import entity.PageMode;
import entity.PageParam;
import entity.Topic;

public class TopicService implements ITopicService {
	private TopicDao topicDao = new TopicDaoImpl();
	private SensitivewordFilter filter = new SensitivewordFilter();
	@Override
	public boolean addTopic(String tsid, String tuid, String ttopic,
			String tcontents) {
		String title = filter.replaceSensitiveWord(ttopic, 1, "*");
		String content = filter.replaceSensitiveWord(tcontents, 1, "*");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ttime = df.format(new Date());
		
		int uid = Integer.parseInt(tuid);
		int sid = Integer.parseInt(tsid);
		
		Topic topic = new Topic(0,sid,uid,0,null,title,content,ttime,0,0,uid,ttime);
		SqlSession sqlsession = MyBatisSessionFactory.getSession();
		int result = sqlsession.getMapper(SessionDao.class).addSessionStopiccount(sid);
		
		MyBatisSessionFactory.closeSession();
		if(result>0){
			return topicDao.addTopic(topic)>0;
		}else {
			return false;
		}	
	}

	@Override
	public List<Topic> querySameTopicListByTSID(int tsid) {
		List<Topic> topicList = null;
		topicList = topicDao.querySameTopicListByTSID(tsid);
		return topicList;
	}

	@Override
	public Topic queryTopicOneByTopic(int tid) {
		return topicDao.queryTopicOneByTopic(tid);
	}

	@Override
	public boolean updateClickCount(String id) {
		int tid = Integer.parseInt(id);
		return topicDao.updateClickCount(tid)>0;
	}

	@Override
	public List<Topic> searchTopicAndContents(String text) {
		return topicDao.searchTopicAndContents(text);
	}

	@Override
	public List<Topic> queryHotsTopicList() {
		return topicDao.queryHotsTopicList();
	}

	@Override
	public PageMode<Topic> queryUserAllTopic(int pageno,int pagesize,String uid) {
		int id = Integer.parseInt(uid);
		PageParam pageParam = new PageParam(pageno,pagesize,id);
		return topicDao.queryUserAllTopic(pageParam);
	}

	@Override
	public boolean deleteTopic(String tid) {
		int topic_id = Integer.parseInt(tid);
		Topic topic = queryTopicOneByTopic(topic_id);
		SqlSession sqlsession = MyBatisSessionFactory.getSession();
		int result = sqlsession.getMapper(TopicDao.class).deleteTopic(topic_id);
		//帖子数减一
		sqlsession.getMapper(SessionDao.class).subSessionStopiccount(topic.getTsid());
		sqlsession.commit();
		MyBatisSessionFactory.closeSession();
		return result>0;
	}

	
}
