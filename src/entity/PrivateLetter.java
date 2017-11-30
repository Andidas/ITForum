package entity;

public class PrivateLetter {
	
	

	public PrivateLetter(int user_id, int friend_id, int puid, int ptouid,int message_type,
			String ptime, String pcontent) {
		super();
		this.message_type = message_type;
		this.user_id = user_id;
		this.friend_id = friend_id;
		this.puid = puid;
		this.ptouid = ptouid;
		this.ptime = ptime;
		this.pcontent = pcontent;
	}
	public PrivateLetter(int user_id, int friend_id, int puid, int ptouid,
			int message_type, String ptime, String pcontent, String pstatus) {
		super();
		this.user_id = user_id;
		this.friend_id = friend_id;
		this.puid = puid;
		this.ptouid = ptouid;
		this.message_type = message_type;
		this.ptime = ptime;
		this.pcontent = pcontent;
		this.pstatus = pstatus;
	}
	public PrivateLetter() {
		super();
	}
	
	private int pid;
	private int user_id;
	private int friend_id;
	private int puid;
	private int ptouid;
	private int message_type;
	private String ptime;
	private String pcontent;
	private String pstatus;
	
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
	
	@Override
	public String toString() {
		return "PrivateLetter [pid=" + pid + ", puid=" + puid + ", ptouid="
				+ ptouid + ", ptime=" + ptime + ", pcontent=" + pcontent
				+ ", pisreaded=" + pstatus + "]";
	}
	public String getPstatus() {
		return pstatus;
	}
	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getFriend_id() {
		return friend_id;
	}
	public void setFriend_id(int friend_id) {
		this.friend_id = friend_id;
	}
	public int getMessage_type() {
		return message_type;
	}
	public void setMessage_type(int message_type) {
		this.message_type = message_type;
	}
}
