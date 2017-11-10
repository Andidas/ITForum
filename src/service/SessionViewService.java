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
	private TopicViewService topicViewService = new TopicViewService();
	private UserService userService = new UserService();
	private FollowService followService = new FollowService();
	
	private PageMode<TopicView> topicViewPM = null;
	private String sessionMaster = null;
	private List<Session> sameSprofile =null;
	private int follow = 0;
	
	public void setTopicViewContents(List<TopicView> TopicViews){
		
		for (int i = 0; i<TopicViews.size();i++) {	
			//�����������ӵ�����
			String newcontents = topicViewService.neatenSessionContentInit(TopicViews.get(i).getTcontents());
			TopicViews.get(i).setTcontents(newcontents);
		}
		
	}
	public SessionView getSessionView(String id) {
		int sid = Integer.parseInt(id);
		SessionView sessionView = new SessionView();
		// ��õ�ǰsession��������Ϣ
		Session session = sessionService.searchSession(sid);
		
		// �������ڰ���topic
		if(session!=null){
			
			topicViewPM = topicViewService.TopicSplitPage(1, 5, session.getSid());
			
			setTopicViewContents(topicViewPM.getData());
			// ��������
			sessionMaster = userService.queryUserNameById(session.getSmasterid());
			// ���ư��
			sameSprofile = sessionService.querySameSession(session);
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
}
