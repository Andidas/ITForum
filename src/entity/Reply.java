package entity;



/**
 * @author lwy
 * 跟帖表实体类
 * @param rid 跟贴表ID
 * @param rtid 回复主贴ID,外键(引用发贴表的TID)
 * @param rsid 所在版块ID,外键(引用版块表的SID)
 * @param ruid 发贴人ID,外键(引用用户表的UID)
 * @param rfavour 点赞数	
 * @param rcontent 回贴内容
 * @param rtime 回贴时间
 */
public class Reply {
	
	

	public Reply(int rid, int rtid, int rsid, int ruid, int rfavour,
			String rcontent, String rtime) {
		super();
		this.rid = rid;
		this.rtid = rtid;
		this.rsid = rsid;
		this.ruid = ruid;
		this.rfavour = rfavour;
		this.rcontent = rcontent;
		this.rtime = rtime;
	}

	public Reply() {
		super();
	}

	

	private int rid; // 跟贴表ID
	private int rtid; // 回复主贴ID,外键(引用发贴表的TID)
	private int rsid; // 所在版块ID,外键(引用版块表的SID)
	private int ruid; // 发贴人ID,外键(引用用户表的UID)
	private int rfavour; // 点赞数
	private String rcontent; // 回贴内容
	private String rtime; // 回贴时间
	
	

	

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getRtid() {
		return rtid;
	}

	public void setRtid(int rtid) {
		this.rtid = rtid;
	}

	public int getRsid() {
		return rsid;
	}

	public void setRsid(int rsid) {
		this.rsid = rsid;
	}

	public int getRuid() {
		return ruid;
	}

	public void setRuid(int ruid) {
		this.ruid = ruid;
	}

	

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRtime() {
		return rtime;
	}

	public void setRtime(String rtime) {
		this.rtime = rtime;
	}

	@Override
	public String toString() {
		return "Reply [rid=" + rid + ", rtid=" + rtid + ", rsid=" + rsid
				+ ", ruid=" + ruid + ", rfavour=" + rfavour + ", rcontent="
				+ rcontent + ", rtime=" + rtime + "]";
	}

	public int getRfavour() {
		return rfavour;
	}

	public void setRfavour(int rfavour) {
		this.rfavour = rfavour;
	}

	



}
