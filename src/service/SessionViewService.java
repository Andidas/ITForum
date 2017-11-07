package service;

import java.util.ArrayList;
import java.util.List;

import entity.Session;
import entity.SessionView;
import entity.Topic;
import entity.TopicView;

/**
 * Ҫ��ʾ��session�����������Ϣ��service
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
		// ��õ�ǰsession��������Ϣ
		Session session = sessionService.searchSession(sname);
		// �������ڰ���topic
		if(session!=null){
			topicList = topicService.queryTopicListByTSID(session.getSid());
			// ��Ӧtopic��topicView
			topicViewList = getTopicViewList(topicList);
			// ��������
			sessionMaster = userService.queryUserNameById(session.getSmasterid());
			// ���ư��
			sameSprofile = sessionService.querySessionByProfile(session.getSprofile());
			// ��ע����
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
		
		// ��Ӧtopic��topicView
		List<TopicView> topicViewList = new ArrayList<TopicView>();
		TopicView topicView = null;
		for (int i = 0; i<topicList.size();i++) {
			String topicTName = topicList.get(i).getTtopic();
			topicView = topicViewService.getTopicView(topicTName);
			//�����������ӵ�����
			String newcontents = topicService.neatenSessionContentInit(topicView.getTopic().getTcontents());
			topicView.getTopic().setTcontents(newcontents);
			
			topicViewList.add(topicView);
		}
		return topicViewList;
	}
}
