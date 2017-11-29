package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import service.iService.ISessionViewService;
import utils.db.MyBatisSessionFactory;
import dao.SessionDao;
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
	//private SessionDao sessionDao = DaoFactory.getInstance(EnumDaoFactory.SESSION).getSessionDao();
	private final static int PAGENO = 1;//�ڼ�ҳ
	private final static int PAGESIZE =5;//ÿҳ����
	
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
		
		PageMode<TopicView> topicViewPM = topicViewService.TopicSplitPage(PAGENO, PAGESIZE, sessionId);

		List<Session> sameSprofile  = sessionService.querySameSession(sessionView.getSprofile(),sessionId);
		int follow = followService.queryFollowCount(sessionId);
		sessionView.setTopicViewPM(topicViewPM);
		sessionView.setSameSprofile(sameSprofile);
		sessionView.setFollow(follow);
		return sessionView;
	}

}
