package entity;

/**
 * @author lwy
 * 板块实体类,id不可修改
 * @param sid 版块ID
 * @param sname 版块名称，唯一
 * @param smasterid 版主ID,外键(引用用户表的UID)
 * @param sprofile 版块主题
 * @param sstatement 本版留言
 * @param stopiccount 发贴数
 * @param sclickcount 点击率
 * @param spicture 版块头像
 */

public class Session {
	
	public Session(int sid, String sname, int smasterid, String sprofile,
			String sstatement, int stopiccount, int sclickcount,
			String spicture) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.smasterid = smasterid;
		this.sprofile = sprofile;
		this.sstatement = sstatement;
		this.stopiccount = stopiccount;
		this.sclickcount = sclickcount;
		this.spicture = spicture;
	}
	public Session() {
		super();
	}

	protected int sid; // 版块ID
	protected String sname; // 版块名称
	protected int smasterid; // 版主ID,外键(引用用户表的UID)
	protected String sprofile; // 版块主题
	protected String sstatement; // 本版留言
	protected int stopiccount; // 发贴数
	protected int sclickcount; // 点击率
	protected String spicture; //版块头像
	
	public int getSid() {
		return sid;
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

	public String getSpicture() {
		return spicture;
	}

	public void setSpicture(String spicture) {
		this.spicture = spicture;
	}

	

	public void setSid(int sid) {
		this.sid = sid;
	}
	@Override
	public String toString() {
		return "Session [sid=" + sid + ", sname=" + sname + ", smasterid="
				+ smasterid + ", sprofile=" + sprofile + ", sstatement="
				+ sstatement + ", stopiccount=" + stopiccount
				+ ", sclickcount=" + sclickcount + ", spicture=" + spicture
				+ "]";
	}

}
