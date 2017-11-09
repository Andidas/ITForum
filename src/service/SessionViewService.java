package service;

import java.util.List;

import entity.PageMode;
import entity.Session;
import entity.SessionView;
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
	
	private PageMode<TopicView> topicViewPM = null;
	private String sessionMaster = null;
	private List<Session> sameSprofile =null;
	private int follow = 0;
	public SessionView getSessionView(String sname) {
		SessionView sessionView = new SessionView();
		// ��õ�ǰsession��������Ϣ
		Session session = sessionService.searchSession(sname);
		
		// �������ڰ���topic
		if(session!=null){
			
			topicViewPM = topicService.TopicSplitPage(1, 5, session.getSid());
			
			setTopicViewContents(topicViewPM.getData());
			// ��������
			sessionMaster = userService.queryUserNameById(session.getSmasterid());
			// ���ư��
			sameSprofile = sessionService.querySessionByProfile(session.getSprofile());
			// ��ע����
			follow = followService.queryFollowCountBySid(session.getSid());
			
			sessionView.setSession(session);
			sessionView.setTopicViewList(topicViewPM.getData());
			sessionView.setSessionMaster(sessionMaster);
			sessionView.setSameSprofile(sameSprofile);
			sessionView.setFollow(follow);
			
			return sessionView;
		}else{
			return null;
		}
		
	}
	public void setTopicViewContents(List<TopicView> TopicViews){
		
		for (int i = 0; i<TopicViews.size();i++) {	
			//�����������ӵ�����
			String newcontents = topicService.neatenSessionContentInit(TopicViews.get(i).getTcontents());
			TopicViews.get(i).setTcontents(newcontents);
		}
		
	}
}
