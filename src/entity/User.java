package entity;



/**
 * @author lwy
 * 实体类,uid,uemail,uregdate不可改
 * @param uid 用户ID
 * @param uname 用户昵称，唯一
 * @param upassword 密码
 * @param uemail 电子邮件，唯一
 * @param ubirthady 生日
 * @param usex 性别
 * @param uhead 用户头像
 * @param usatement 用户备注
 * @param uregdate 注册日期
 * @param ustate 用户状态
 * @param upoint 用户积分
 * @param uissectioner 是否版主
 */
public class User implements Cloneable{

	public User(int uid, String uname, String upassword, String uemail,
			String uregdate, String ubirthady, int usex, String uhead,
			String usatement, int ustate, int upoint, int uissectioner) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upassword = upassword;
		this.uemail = uemail;
		this.uregdate = uregdate;
		this.ubirthady = ubirthady;
		this.usex = usex;
		this.uhead = uhead;
		this.usatement = usatement;
		this.ustate = ustate;
		this.upoint = upoint;
		this.uissectioner = uissectioner;
	}
	public User() {
		super();
	}
	//��¡�ӿ�ʵ��
	@Override
	public Object clone() throws CloneNotSupportedException {
			return super.clone();
	}
	

	private int uid;
	private String uname;
	private String upassword;
	private String uemail;
	private String uregdate;
	private String ubirthady;
	private int usex;
	private String uhead;
	private String usatement;
	private int ustate;
	private int upoint;
	private int uissectioner;
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upassword="
				+ upassword + ", uemail=" + uemail + ", uregdate=" + uregdate
				+ ", ubirthady=" + ubirthady + ", usex=" + usex + ", uhead="
				+ uhead + ", usatement=" + usatement + ", ustate=" + ustate
				+ ", upoint=" + upoint + ", uissectioner=" + uissectioner + "]";
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUregdate() {
		return uregdate;
	}
	public void setUregdate(String uregdate) {
		this.uregdate = uregdate;
	}
	public String getUbirthady() {
		return ubirthady;
	}
	public void setUbirthady(String ubirthady) {
		this.ubirthady = ubirthady;
	}
	public int getUsex() {
		return usex;
	}
	public void setUsex(int usex) {
		this.usex = usex;
	}
	public String getUhead() {
		return uhead;
	}
	public void setUhead(String uhead) {
		this.uhead = uhead;
	}
	public String getUsatement() {
		return usatement;
	}
	public void setUsatement(String usatement) {
		this.usatement = usatement;
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

