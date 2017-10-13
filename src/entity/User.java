package entity;



/**
 * @author lwy
 * ʵ����,uid,uemail,uregdate���ɸ�
 * @param uid �û�ID
 * @param uname �û��ǳ�
 * @param upassword ����
 * @param uemail �����ʼ�
 * @param ubirthady ����
 * @param usex �Ա�
 * @param uhead �û�ͷ��
 * @param usatement �û���ע
 * @param uregdate ע������
 * @param ustate �û�״̬
 * @param upoint �û�����
 * @param uissectioner �Ƿ����
 */
public class User {

	/**
	 * ȫ������
	 */
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

	/**
	 * һ��ʼ�����ʼ��ֵ
	 * @param uname
	 * @param upassword
	 * @param uemail
	 * @param uregdate
	 */
	public User(String uname, String upassword, String uemail,
			String uregdate) {
		super();
		this.uname = uname;
		this.upassword = upassword;
		this.uemail = uemail;
		this.uregdate = uregdate;
	}

	public User() {
		super();
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

	public int getUid() {
		return uid;
	}

	public String getUemail() {
		return uemail;
	}

	public String getUregdate() {
		return uregdate;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upassword="
				+ upassword + ", uemail=" + uemail + ", uregdate=" + uregdate
				+ ", ubirthady=" + ubirthady + ", usex=" + usex + ", uhead="
				+ uhead + ", usatement=" + usatement + ", ustate=" + ustate
				+ ", upoint=" + upoint + ", uissectioner=" + uissectioner + "]";
	}



	
}
