package entity;

/**
 * ������ͼʵ����
 * @author lwy
 *	@param rid //����id
 * @param uname //������
 * @param rfavour // ������������
 * @param rcontent //��������
 * @param rtime // ����ʱ��
 * @param ustate // ������״̬
 * @param upoint // �����˻���
 * @param uissectioner // �������Ƿ��ǰ���
 */
public class ReplyView {
	/**
	 * 
	 */
	public ReplyView(int rid, String uname, int rfavour, String rcontent,
			String rtime, int ustate, int upoint, int uissectioner) {
		super();
		this.rid = rid;
		this.uname = uname;
		this.rfavour = rfavour;
		this.rcontent = rcontent;
		this.rtime = rtime;
		this.ustate = ustate;
		this.upoint = upoint;
		this.uissectioner = uissectioner;
	}
	public ReplyView() {
		super();
	}
	private int rid;
	private String uname;
	private int rfavour;
	private String rcontent;
	private String rtime;
	private int ustate;
	private int upoint;
	private int uissectioner;
	@Override
	public String toString() {
		return "ReplyView [rid=" + rid + ", uname=" + uname + ", rfavour="
				+ rfavour + ", rcontent=" + rcontent + ", rtime=" + rtime
				+ ", ustate=" + ustate + ", upoint=" + upoint
				+ ", uissectioner=" + uissectioner + "]";
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getRfavour() {
		return rfavour;
	}
	public void setRfavour(int rfavour) {
		this.rfavour = rfavour;
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
