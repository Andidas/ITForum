package service;

import java.util.List;

import service.iService.ISessionViewService;
import utils.ConstantsData.EnumDaoFactory;
import dao.SessionDao;
import dao.factory.DaoFactory;
import entity.PageMode;
import entity.Session;
import entity.viewEntity.SessionView;
import entity.viewEntity.TopicView;

/**
 * Ҫ��ʾ��session�����������Ϣ��service
 * 
 * @author lwy
 *
 */
public class SessionViewService implements ISessionViewService{
	private SessionDao sessionDao = DaoFactory.getInstance(EnumDaoFactory.SESSION).getSessionDao();
	private final static int PAGENO = 1;//�ڼ�ҳ
	private final static int PAGESIZE =5;//ÿҳ����
	
	private SessionService sessionService = new SessionService();
	private TopicViewService topicViewService = new TopicViewService();
	private FollowService followService = new FollowService();
	
	
	@Override
	public SessionView querySessionView(String sid) {
		if(sid==null||sid.equals(""))return null;
		
		int sessionId = Integer.parseInt(sid);
		SessionView sessionView =sessionDao.querySessionView(sessionId);
		
		PageMode<TopicView> topicViewPM = topicViewService.TopicSplitPage(PAGENO, PAGESIZE, sessionId);

		List<Session> sameSprofile  = sessionService.querySameSession(sessionView.getSprofile(),sessionId);
		int follow = followService.queryFollowCount(sessionId);
		sessionView.setTopicViewPM(topicViewPM);
		sessionView.setSameSprofile(sameSprofile);
		sessionView.setFollow(follow);
		return sessionView;
	}

}
