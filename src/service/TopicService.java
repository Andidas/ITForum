package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import dao.impl.SessionDaoImpl;
import dao.impl.TopicDaoImpl;
import entity.Topic;
import service.iService.ITopicService;

public class TopicService implements ITopicService {
	private TopicDaoImpl tdi = new TopicDaoImpl();
	private SessionDaoImpl sdi = new SessionDaoImpl();
	
	@Override
	public boolean addTopic(String tsid, String tuid, String ttopic,
			String tcontents) {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ttime = df.format(new Date());//获取注册时间
		//得到用户id
		int uid = Integer.parseInt(tuid);
		//得到session的id
		int sid = Integer.parseInt(tsid);
		//生成topic
		Topic topic = new Topic(0,sid,uid,0,null,ttopic,tcontents,ttime,0,0,uid,ttime);
		if(sdi.addSessionStopiccount(sid)>0){
			return tdi.addTopic(topic)>0;
		}else {
			return false;
		}	
	}

	@Override
	public List<Topic> querySameTopicListByTSID(int tsid) {
		List<Topic> topicList = null;
		topicList = tdi.querySameTopicListByTSID(tsid);
		return topicList;
	}

	@Override
	public Topic queryTopicOneByTopic(int tid) {
		return tdi.queryTopicOneByTopic(tid);
	}

	@Override
	public boolean updateClickCount(String id) {
		int tid = Integer.parseInt(id);
		return tdi.updateClickCount(tid)>0;
	}
	
	

	

	
	
	

}
