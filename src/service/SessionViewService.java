package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import service.iService.ISessionViewService;
import utils.ConstantsData;
import utils.db.MyBatisSessionFactory;
import dao.SessionDao;
import entity.PageMode;
import entity.Session;
import entity.viewEntity.SessionView;
import entity.viewEntity.TopicView;


public class SessionViewService implements ISessionViewService{
	
	private SessionService sessionService = new SessionService();
	private TopicViewService topicViewService = new TopicViewService();
	private FollowService followService = new FollowService();
	
	
	@Override
	public SessionView querySessionView(String sid) {
		SqlSession sqlsession = MyBatisSessionFactory.getSession();
		
		if(sid==null||sid.equals(""))return null;
		
		int sessionId = Integer.parseInt(sid);
		SessionView sessionView =sqlsession.getMapper(SessionDao.class).querySessionView(sessionId);
		MyBatisSessionFactory.closeSession();
		
		PageMode<TopicView> topicViewPM = topicViewService.TopicSplitPage(ConstantsData.PAGENO, ConstantsData.PAGESIZE, sessionId);

		List<Session> sameSprofile  = sessionService.querySameSession(sessionView.getSprofile(),sessionId);
		int follow = followService.queryFollowCount(sessionId);
		sessionView.setTopicViewPM(topicViewPM);
		sessionView.setSameSprofile(sameSprofile);
		sessionView.setFollow(follow);
		return sessionView;
	}

}
