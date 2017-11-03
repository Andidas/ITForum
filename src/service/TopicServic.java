package service;

import java.text.SimpleDateFormat;
import java.util.Date;

import dao.impl.SessionDaoImpl;
import dao.impl.TopicDaoImpl;
import dao.impl.UserDaoImpl;
import entity.Topic;
import service.iService.ITopicServic;

public class TopicServic implements ITopicServic {
	

	@Override
	public boolean addUser(String sname, String uname, String ttopic,
			String tcontents) {
		TopicDaoImpl topicDao = new TopicDaoImpl();
		UserDaoImpl userDao = new UserDaoImpl();
		SessionDaoImpl sessionDao = new SessionDaoImpl();
		
		Topic topic = new Topic();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ttime = df.format(new Date());//获取注册时间
		
		int tuid = userDao.queryUserIDByName(uname);//得到用户id
		topic.setTuid(tuid);
		int tsid = sessionDao.querySessionIDByName(sname);//得到session的id
		topic.setTsid(tsid);
		topic.setTtopic(ttopic);
		topic.setTcontents(tcontents);
		topic.setTtime(ttime);
		
		int result = topicDao.addTopic(topic);
		
		return result>0;
	}
	

	

}
