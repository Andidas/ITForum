package entity;

public class PrivateLetter {
	public PrivateLetter(int puid, int ptouid, String ptime, String pcontent) {
		super();
		this.puid = puid;
		this.ptouid = ptouid;
		this.ptime = ptime;
		this.pcontent = pcontent;
	}
	public PrivateLetter() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public PrivateLetter(int pid, int puid, int ptouid, String ptime,
			String pcontent) {
		super();
		this.pid = pid;
		this.puid = puid;
		this.ptouid = ptouid;
		this.ptime = ptime;
		this.pcontent = pcontent;
	}
	private int pid;
	private int puid;
	private int ptouid;
	private String ptime;
	private String pcontent;
	@Override
	public String toString() {
		return "PrivateLetter [pid=" + pid + ", puid=" + puid + ", ptouid="
				+ ptouid + ", ptime=" + ptime + ", pcontent=" + pcontent + "]";
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getPuid() {
		return puid;
	}
	public void setPuid(int puid) {
		this.puid = puid;
	}
	public int getPtouid() {
		return ptouid;
	}
	public void setPtouid(int ptouid) {
		this.ptouid = ptouid;
	}
	public String getPtime() {
		return ptime;
	}
	public void setPtime(String ptime) {
		this.ptime = ptime;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
}
