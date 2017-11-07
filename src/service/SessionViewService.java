package service;

import java.util.ArrayList;
import java.util.List;

import entity.Session;
import entity.SessionView;
import entity.Topic;
import entity.TopicView;

/**
 * 要显示在session界面的所有信息的service
 * 
 * @author lwy
 *
 */
public class SessionViewService {
	private SessionService sessionService = new SessionService();
	private TopicService topicService = new TopicService();
	private UserService userService = new UserService();
	private FollowService followService = new FollowService();
	private TopicViewService topicViewService = new TopicViewService();
	private List<Topic> topicList = null;
	private List<TopicView> topicViewList = null;
	private String sessionMaster = null;
	private List<Session> sameSprofile =null;
	private int follow = 0;
	public SessionView getSessionView(String sname) {
		SessionView sessionView = new SessionView();
		// 获得当前session的所有信息
		Session session = sessionService.searchSession(sname);
		// 所有属于版块的topic
		if(session!=null){
			topicList = topicService.queryTopicListByTSID(session.getSid());
			// 相应topic的topicView
			topicViewList = getTopicViewList(topicList);
			// 版块的作者
			sessionMaster = userService.queryUserNameById(session.getSmasterid());
			// 相似版块
			sameSprofile = sessionService.querySessionByProfile(session.getSprofile());
			// 关注人数
			follow = followService.queryFollowCountBySid(session.getSid());
			
			sessionView.setSession(session);
			sessionView.setTopicViewList(topicViewList);
			sessionView.setSessionMaster(sessionMaster);
			sessionView.setSameSprofile(sameSprofile);
			sessionView.setFollow(follow);
			
			return sessionView;
		}else{
			return null;
		}
		
	}
	private List<TopicView> getTopicViewList(List<Topic> topicList){
		
		// 相应topic的topicView
		List<TopicView> topicViewList = new ArrayList<TopicView>();
		TopicView topicView = null;
		for (int i = 0; i<topicList.size();i++) {
			String topicTName = topicList.get(i).getTtopic();
			topicView = topicViewService.getTopicView(topicTName);
			//重新排列帖子的内容
			String newcontents = topicService.neatenSessionContentInit(topicView.getTopic().getTcontents());
			topicView.getTopic().setTcontents(newcontents);
			
			topicViewList.add(topicView);
		}
		return topicViewList;
	}
}
