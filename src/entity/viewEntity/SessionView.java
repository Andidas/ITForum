package entity.viewEntity;

import java.util.List;

import entity.PageMode;
import entity.Session;

/**
 * @author lwy
 * @param sid
 * @param sname
 * @param smasterid
 * @param sprofile
 * @param sstatement
 * @param stopiccount
 * @param sclickcount
 * @param spicture
 * @param uname 用户名
 * @param topicViewPM topic视图
 * @param sameSprofile 相似版块
 * @param follow 关注数
 */
public class SessionView extends Session {


	
	public SessionView(int sid, String sname, int smasterid, String sprofile,
			String sstatement, int stopiccount, int sclickcount,
			String spicture, String uname, PageMode<TopicView> topicViewPM,
			List<Session> sameSprofile, int follow) {
		super(sid, sname, smasterid, sprofile, sstatement, stopiccount,
				sclickcount, spicture);
		this.uname = uname;
		this.topicViewPM = topicViewPM;
		this.sameSprofile = sameSprofile;
		this.follow = follow;
	}
	public SessionView() {
		super();
	}
	public SessionView(int sid, String sname, int smasterid, String sprofile,
			String sstatement, int stopiccount, int sclickcount, String spicture) {
		super(sid, sname, smasterid, sprofile, sstatement, stopiccount, sclickcount,
				spicture);
	}
	private String uname;
	private PageMode<TopicView> topicViewPM = null;
	private List<Session> sameSprofile;
	private int follow ;
	
	public String getUname() {
		return uname;
		
	}
	public void setUname(String uname) {
		this.uname = uname;
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
	
	public PageMode<TopicView> getTopicViewPM() {
		return topicViewPM;
	}
	public void setTopicViewPM(PageMode<TopicView> topicViewPM) {
		this.topicViewPM = topicViewPM;
	}
	@Override
	public String toString() {
		return "SessionView [uname=" + uname + ", topicViewPM=" + topicViewPM
				+ ", sameSprofile=" + sameSprofile + ", follow=" + follow
				+ ", sid=" + sid + ", sname=" + sname + ", smasterid="
				+ smasterid + ", sprofile=" + sprofile + ", sstatement="
				+ sstatement + ", stopiccount=" + stopiccount
				+ ", sclickcount=" + sclickcount + ", spicture=" + spicture
				+ "]";
	}
	
	
	
	
	

	
}
