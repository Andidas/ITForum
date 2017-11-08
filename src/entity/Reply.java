package entity;



/**
 * @author lwy
 * ������ʵ����
 * @param rid ������ID
 * @param rtid �ظ�����ID,���(���÷������TID)
 * @param rsid ���ڰ��ID,���(���ð����SID)
 * @param ruid ������ID,���(�����û����UID)
 * @param rfavour ������	
 * @param rcontent ��������
 * @param rtime ����ʱ��
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

	

	private int rid; // ������ID
	private int rtid; // �ظ�����ID,���(���÷������TID)
	private int rsid; // ���ڰ��ID,���(���ð����SID)
	private int ruid; // ������ID,���(�����û����UID)
	private int rfavour; // ������
	private String rcontent; // ��������
	private String rtime; // ����ʱ��
	
	

	

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
