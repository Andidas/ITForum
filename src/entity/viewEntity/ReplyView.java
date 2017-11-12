package entity.viewEntity;

import entity.Reply;

/**
 * ������ͼʵ����
 * @author lwy
 * @param uname ������
 * @param ustate  ������״̬
 * @param upoint �����˻���
 * @param uissectioner �������Ƿ��ǰ���
 */
public class ReplyView extends Reply{
	
	public ReplyView(int rid, int rtid, int rsid, int ruid, int rfavour,
			String rcontent, String rtime, String uname, int ustate,
			int upoint, int uissectioner) {
		super(rid, rtid, rsid, ruid, rfavour, rcontent, rtime);
		this.uname = uname;
		this.ustate = ustate;
		this.upoint = upoint;
		this.uissectioner = uissectioner;
	}
	public ReplyView(int rid, int rtid, int rsid, int ruid, int rfavour,
			String rcontent, String rtime) {
		super(rid, rtid, rsid, ruid, rfavour, rcontent, rtime);
	}
	public ReplyView() {
		super();
	}
	private String uname;
	private int ustate;
	private int upoint;
	private int uissectioner;
	@Override
	public String toString() {
		return "ReplyView [uname=" + uname + ", ustate=" + ustate + ", upoint="
				+ upoint + ", uissectioner=" + uissectioner + ", rid=" + rid
				+ ", rtid=" + rtid + ", rsid=" + rsid + ", ruid=" + ruid
				+ ", rfavour=" + rfavour + ", rcontent=" + rcontent
				+ ", rtime=" + rtime + "]";
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getUstate() {
		return ustate;
	}
	public void setUstate(int ustate) {
		this.ustate = ustate;
	}
	public int getUpoint() {
		return upoint;
	}
	public void setUpoint(int upoint) {
		this.upoint = upoint;
	}
	public int getUissectioner() {
		return uissectioner;
	}
	public void setUissectioner(int uissectioner) {
		this.uissectioner = uissectioner;
	}
	
	
}
