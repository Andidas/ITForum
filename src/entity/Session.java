package entity;

/**
 * @author lwy
 * ���ʵ����
 * @param sid ���ID
 * @param sname �������
 * @param smasterid ����ID,���(�����û����UID)
 * @param sprofile �������
 * @param sstatement ��������
 * @param stopiccount ������
 * @param sclickcount �����
 */
public class Session {
	/**
	 * һ��ʼ��Ҫ��ʼ��������
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
	private int sid; // ���ID
	private String sname; // �������
	private int smasterid; // ����ID,���(�����û����UID)
	private String sprofile; // �������
	private String sstatement; // ��������
	private int stopiccount; // ������
	private int sclickcount; // �����
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
