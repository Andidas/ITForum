package entity;



/**
 * @author lwy
 * ������ʵ����
 * @param rid ������ID
 * @param rtid �ظ�����ID,���(���÷������TID)
 * @param rsid ���ڰ��ID,���(���ð����SID)
 * @param ruid ������ID,���(�����û����UID)
 * @param temotion ��������	
 * @param rcontent ��������
 * @param rtime ����ʱ��
 */
public class Reply {
	/**
	 * һ��ʼ�����ʼ��ֵ
	 * @param rid
	 * @param rtid
	 * @param rsid
	 * @param ruid
	 * @param rcontent
	 * @param rtime
	 */
	public Reply(int rid, int rtid, int rsid, int ruid, String rcontent,
			String rtime) {
		super();
		this.rid = rid;
		this.rtid = rtid;
		this.rsid = rsid;
		this.ruid = ruid;
		this.rcontent = rcontent;
		this.rtime = rtime;
	}

	public Reply() {
		super();
	}

	public Reply(int rid, int rtid, int rsid, int ruid, String temotion,
			String rcontent, String rtime) {
		super();
		this.rid = rid;
		this.rtid = rtid;
		this.rsid = rsid;
		this.ruid = ruid;
		this.temotion = temotion;
		this.rcontent = rcontent;
		this.rtime = rtime;
	}

	private int rid; // ������ID
	private int rtid; // �ظ�����ID,���(���÷������TID)
	private int rsid; // ���ڰ��ID,���(���ð����SID)
	private int ruid; // ������ID,���(�����û����UID)
	private String temotion; // ��������
	private String rcontent; // ��������
	private String rtime; // ����ʱ��
	@Override
	public String toString() {
		return "Reply [rid=" + rid + ", rtid=" + rtid + ", rsid=" + rsid
				+ ", ruid=" + ruid + ", temotion=" + temotion + ", rcontent="
				+ rcontent + ", rtime=" + rtime + "]";
	}

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

	public String getTemotion() {
		return temotion;
	}

	public void setTemotion(String temotion) {
		this.temotion = temotion;
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



}
