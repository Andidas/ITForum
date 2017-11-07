package entity;

import java.util.List;

/**
 * @author lwy
 *	要显示在session界面的东西
 *
 * @param session //要显示的版块
 * @param topicList //所有属于版块的topic
 * @param sessionMaster //版块的作者，string
 * @param sameSprofile // 相似版块
 * @param follow //关注人数
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
