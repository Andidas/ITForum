package entity;

import java.util.List;

/**
 * @author lwy
 *	Ҫ��ʾ��session����Ķ���
 *
 * @param session //Ҫ��ʾ�İ��
 * @param topicList //�������ڰ���topic
 * @param sessionMaster //�������ߣ�string
 * @param sameSprofile // ���ư��
 * @param follow //��ע����
 */
public class SessionView {
	
	public SessionView(Session session, List<Topic> topicList,
			String sessionMaster, List<Session> sameSprofile, int follow) {
		super();
		this.session = session;
		this.topicList = topicList;
		this.sessionMaster = sessionMaster;
		this.sameSprofile = sameSprofile;
		this.follow = follow;
	}
	public SessionView() {
		super();
	}
	private Session session = null;
	private List<Topic> topicList = null;
	private String sessionMaster = null;
	private List<Session> sameSprofile = null;
	private int follow = 0;
	@Override
	public String toString() {
		return "SessionView [session=" + session + ", topicList=" + topicList
				+ ", sessionMaster=" + sessionMaster + ", sameSprofile="
				+ sameSprofile + ", follow=" + follow + "]";
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public List<Topic> getTopicList() {
		return topicList;
	}
	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
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
	
}
