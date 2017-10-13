package entity;

/**
 * @author lwy
 * 板块实体类
 * @param sid 版块ID
 * @param sname 版块名称
 * @param smasterid 版主ID,外键(引用用户表的UID)
 * @param sprofile 版块主题
 * @param sstatement 本版留言
 * @param stopiccount 发贴数
 * @param sclickcount 点击率
 */
public class Session {
	/**
	 * 一开始需要初始化的数据
	 * @param sid
	 * @param sname
	 * @param smasterid
	 */
	public Session(int sid, String sname, int smasterid) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.smasterid = smasterid;
	}

	public Session() {
		super();
	}

	public Session(int sid, String sname, int smasterid, String sprofile,
			String sstatement, int stopiccount, int sclickcount) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.smasterid = smasterid;
		this.sprofile = sprofile;
		this.sstatement = sstatement;
		this.stopiccount = stopiccount;
		this.sclickcount = sclickcount;
	}
	private int sid; // 版块ID
	private String sname; // 版块名称
	private int smasterid; // 版主ID,外键(引用用户表的UID)
	private String sprofile; // 版块主题
	private String sstatement; // 本版留言
	private int stopiccount; // 发贴数
	private int sclickcount; // 点击率
	@Override
	public String toString() {
		return "Session [sid=" + sid + ", sname=" + sname + ", smasterid="
				+ smasterid + ", sprofile=" + sprofile + ", sstatement="
				+ sstatement + ", stopiccount=" + stopiccount
				+ ", sclickcount=" + sclickcount + "]";
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSmasterid() {
		return smasterid;
	}
	public void setSmasterid(int smasterid) {
		this.smasterid = smasterid;
	}
	public String getSprofile() {
		return sprofile;
	}
	public void setSprofile(String sprofile) {
		this.sprofile = sprofile;
	}
	public String getSstatement() {
		return sstatement;
	}
	public void setSstatement(String sstatement) {
		this.sstatement = sstatement;
	}
	public int getStopiccount() {
		return stopiccount;
	}
	public void setStopiccount(int stopiccount) {
		this.stopiccount = stopiccount;
	}
	public int getSclickcount() {
		return sclickcount;
	}
	public void setSclickcount(int sclickcount) {
		this.sclickcount = sclickcount;
	}

}
