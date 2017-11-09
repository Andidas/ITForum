package entity;

import java.util.List;

/**
 * @author lwy
 *	要显示在topic界面的东西
 * @param tid topic的id
 * @param tsid session的id
 * @param sname session的name
 * @param uname 发布这个帖子的user
 * @param treplycount 回帖数
 * @param ttopic 题目
 * @param tcontents 内容
 * @param ttime 发帖时间
 * @param tclickcount 点击数
 * @param lastreplyuser 最后回复的user
 * @param tlastreplaytime 最后回复的时间
 * @param sameTopic 相同的topic
 * @param allReply 该topic的所有reply视图
 */
public class TopicView {
	
	
	public TopicView(int tid, int tsid, String sname, String uname,
			int treplycount, String ttopic, String tcontents, String ttime,
			int tclickcount, String lastreplyuser, String tlastreplaytime,
			List<Topic> sameTopic, PageMode<ReplyView> allReply) {
		super();
		this.tid = tid;
		this.tsid = tsid;
		this.sname = sname;
		this.uname = uname;
		this.treplycount = treplycount;
		this.ttopic = ttopic;
		this.tcontents = tcontents;
		this.ttime = ttime;
		this.tclickcount = tclickcount;
		this.lastreplyuser = lastreplyuser;
		this.tlastreplaytime = tlastreplaytime;
		this.sameTopic = sameTopic;
		this.allReply = allReply;
	}
	public TopicView() {
		super();
		
	}
	
	private int tid;
	private int tsid;
	private String sname;
	private String uname;
	private int treplycount;
	private String ttopic;
	private String tcontents;
	private String ttime;
	private int tclickcount; 
	private String lastreplyuser;
	private String tlastreplaytime;
	private List<Topic> sameTopic;
	private PageMode<ReplyView> allReply;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getTreplycount() {
		return treplycount;
	}
	public void setTreplycount(int treplycount) {
		this.treplycount = treplycount;
	}
	public String getTtopic() {
		return ttopic;
	}
	public void setTtopic(String ttopic) {
		this.ttopic = ttopic;
	}
	public String getTcontents() {
		return tcontents;
	}
	public void setTcontents(String tcontents) {
		this.tcontents = tcontents;
	}
	public String getTtime() {
		return ttime;
	}
	public void setTtime(String ttime) {
		this.ttime = ttime;
	}
	public int getTclickcount() {
		return tclickcount;
	}
	public void setTclickcount(int tclickcount) {
		this.tclickcount = tclickcount;
	}
	public String getLastreplyuser() {
		return lastreplyuser;
	}
	public void setLastreplyuser(String lastreplyuser) {
		this.lastreplyuser = lastreplyuser;
	}
	public String getTlastreplaytime() {
		return tlastreplaytime;
	}
	public void setTlastreplaytime(String tlastreplaytime) {
		this.tlastreplaytime = tlastreplaytime;
	}
	public List<Topic> getSameTopic() {
		return sameTopic;
	}
	public void setSameTopic(List<Topic> sameTopic) {
		this.sameTopic = sameTopic;
	}
	public PageMode<ReplyView> getAllReply() {
		return allReply;
	}
	public void setAllReply(PageMode<ReplyView> allReply) {
		this.allReply = allReply;
	}
	@Override
	public String toString() {
		return "TopicView [tid=" + tid + ", tsid=" + tsid + ", sname=" + sname
				+ ", uname=" + uname + ", treplycount=" + treplycount
				+ ", ttopic=" + ttopic + ", tcontents=" + tcontents
				+ ", ttime=" + ttime + ", tclickcount=" + tclickcount
				+ ", lastreplyuser=" + lastreplyuser + ", tlastreplaytime="
				+ tlastreplaytime + ", sameTopic=" + sameTopic + ", allReply="
				+ allReply + "]";
	}
	public int getTsid() {
		return tsid;
	}
	public void setTsid(int tsid) {
		this.tsid = tsid;
	}
	
	
	
	
	
}
