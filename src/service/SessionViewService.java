package service;

import java.util.List;

import service.iService.ISessionViewService;
import dao.impl.SessionDaoImpl;
import entity.PageMode;
import entity.Session;
import entity.viewEntity.TopicView;
import entity.viewEntity.SessionView;

/**
 * 要显示在session界面的所有信息的service
 * 
 * @author lwy
 *
 */
public class SessionViewService implements ISessionViewService{
	private SessionDaoImpl sdi = new SessionDaoImpl();
	private final static int PAGENO = 1;//第几页
	private final static int PAGESIZE =5;//每页条数
	
	private SessionService sessionService = new SessionService();
	private TopicViewService topicViewService = new TopicViewService();
	private FollowService followService = new FollowService();
	
	@Override
	public void setTopicViewContents(List<TopicView> TopicViews){
		
		for (int i = 0; i<TopicViews.size();i++) {	
			
			String newcontents = topicViewService.neatenSessionContentInit(TopicViews.get(i).getTcontents());
			TopicViews.get(i).setTcontents(newcontents);
		}
		
	}
	@Override
	public SessionView querySessionView(String sid) {
		if(sid==null||sid.equals(""))return null;
		
		int sessionId = Integer.parseInt(sid);
		SessionView sessionView =sdi.querySessionView(sessionId);
		
		PageMode<TopicView> topicViewPM = topicViewService.TopicSplitPage(PAGENO, PAGESIZE, sessionView.getSid());
		setTopicViewContents(topicViewPM.getData());
		
		List<Session> sameSprofile  = sessionService.querySameSession(sessionView.getSprofile(),sessionView.getSid());
		int follow = followService.queryFollowCount(sessionView.getSid());
		sessionView.setTopicViewPM(topicViewPM);
		sessionView.setSameSprofile(sameSprofile);
		sessionView.setFollow(follow);
		return sessionView;
	}

}
