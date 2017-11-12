package entity;

/**
 * @author lwy
 * ���ʵ����,id�����޸�
 * @param sid ���ID
 * @param sname ������ƣ�Ψһ
 * @param smasterid ����ID,���(�����û����UID)
 * @param sprofile �������
 * @param sstatement ��������
 * @param stopiccount ������
 * @param sclickcount �����
 * @param spicture ���ͷ��
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

	protected int sid; // ���ID
	protected String sname; // �������
	protected int smasterid; // ����ID,���(�����û����UID)
	protected String sprofile; // �������
	protected String sstatement; // ��������
	protected int stopiccount; // ������
	protected int sclickcount; // �����
	protected String spicture; //���ͷ��
	
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
