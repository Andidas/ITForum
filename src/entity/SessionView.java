package entity;

import java.util.List;

/**
 * @author lwy
 *	Ҫ��ʾ��session����Ķ���
 *
 * @param session //Ҫ��ʾ�İ��
 * @param topicViewList //�������ڰ����ͼ��Ϣ��topicView
 * @param sessionMaster //�������ߣ�string
 * @param sameSprofile // ���ư��
 * @param follow //��ע����
 */
public class SessionView {
	
	public SessionView(Session session, List<TopicView> topicViewList,
			String sessionMaster, List<Session> sameSprofile, int follow) {
		super();
		this.session = session;
		this.topicViewList = topicViewList;
		this.sessionMaster = sessionMaster;
		this.sameSprofile = sameSprofile;
		this.follow = follow;
	}
	public SessionView() {
		super();
	}
	private Session session = null;
	private List<TopicView> topicViewList = null;
	private String sessionMaster = null;
	private List<Session> sameSprofile = null;
	private int follow = 0;
	
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	
	public String getSessionMaster() {
		return sessionMaster;
	}
	public void setSessionMaster(String sessionMaster) {
		this.sessionMaster = sessionMaster;
	}
	public List<Session> getSameSprofile() {
		return sameSprofile;
	}
	public void setSameSprofile(List<Session> sameSprofile) {
		this.sameSprofile = sameSprofile;
	}
	public int getFollow() {
		return follow;
	}
	public void setFollow(int follow) {
		this.follow = follow;
	}
	@Override
	public String toString() {
		return "SessionView [session=" + session + ", topicViewList="
				+ topicViewList + ", sessionMaster=" + sessionMaster
				+ ", sameSprofile=" + sameSprofile + ", follow=" + follow + "]";
	}
	public List<TopicView> getTopicViewList() {
		return topicViewList;
	}
	public void setTopicViewList(List<TopicView> topicViewList) {
		this.topicViewList = topicViewList;
	}
	
}
