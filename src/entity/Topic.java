package entity;



/**
 * @author lwy
 * 
 * @param tid  发贴表ID
 * @param tsid 所在版块,外键(引用版块表的SID)
 * @param tuid 发贴人,外键(引用 用户表的UID)
 * @param treplycount 回复数
 * @param temotion 发贴表情 
 * @param ttopic 标题 
 * @param tcontents 正文 
 * @param ttime 发贴时间
 * @param tclickcount 点击率
 * @param tflag 状态 
 * @param tlastreplyuseid 最后回复用户ID,外键(引用用户表的UID)
 * @param tlastreplaytime 最后回复时间
 */
public class Topic {
	

	public Topic() {
		super();
	}

	public Topic(int tid, int tsid, int tuid, int treplycount, String temotion,
			String ttopic, String tcontents, String ttime, int tclickcount,
			int tflag, int tlastreplyuseid, String tlastreplaytime) {
		super();
		this.tid = tid;
		this.tsid = tsid;
		this.tuid = tuid;
		this.treplycount = treplycount;
		this.temotion = temotion;
		this.ttopic = ttopic;
		this.tcontents = tcontents;
		this.ttime = ttime;
		this.tclickcount = tclickcount;
		this.tflag = tflag;
		this.tlastreplyuseid = tlastreplyuseid;
		this.tlastreplaytime = tlastreplaytime;
	}

	private int tid;// �����ID
	private int tsid;// ���ڰ��,���(���ð����SID)
	private int tuid;// ������,���(�����û����UID)
	private int treplycount;// �ظ���
	private String temotion;// ������� 
	private String ttopic;// ���� 
	private String tcontents;// ���� 
	private String ttime;// ����ʱ��
	private int tclickcount;// �����
	private int tflag;// ״̬
	private int tlastreplyuseid;// ���ظ��û�ID,���(�����û����UID)
	private String tlastreplaytime;// ���ظ�ʱ��
	@Override
	public String toString() {
		return "Topic [tid=" + tid + ", tsid=" + tsid + ", tuid=" + tuid
				+ ", treplycount=" + treplycount + ", temotion=" + temotion
				+ ", ttopic=" + ttopic + ", tcontents=" + tcontents
				+ ", ttime=" + ttime + ", tclickcount=" + tclickcount
				+ ", tflag=" + tflag + ", tlastreplyuseid=" + tlastreplyuseid
				+ ", tlastreplaytime=" + tlastreplaytime + "]";
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getTsid() {
		return tsid;
	}

	public void setTsid(int tsid) {
		this.tsid = tsid;
	}

	public int getTuid() {
		return tuid;
	}

	public void setTuid(int tuid) {
		this.tuid = tuid;
	}

	public int getTreplycount() {
		return treplycount;
	}

	public void setTreplycount(int treplycount) {
		this.treplycount = treplycount;
	}

	public String getTemotion() {
		return temotion;
	}

	public void setTemotion(String temotion) {
		this.temotion = temotion;
	}

	public String getTtopic() {
		return ttopic;
	}

	public void setTtopic(String ttopic) {
		this.ttopic = ttopic;
	}

	public String getTcontents() {
		return tcontents;
	}

	public void setTcontents(String tcontents) {
		this.tcontents = tcontents;
	}

	public String getTtime() {
		return ttime;
	}

	public void setTtime(String ttime) {
		this.ttime = ttime;
	}

	public int getTclickcount() {
		return tclickcount;
	}

	public void setTclickcount(int tclickcount) {
		this.tclickcount = tclickcount;
	}

	public int getTflag() {
		return tflag;
	}

	public void setTflag(int tflag) {
		this.tflag = tflag;
	}

	public int getTlastreplyuseid() {
		return tlastreplyuseid;
	}

	public void setTlastreplyuseid(int tlastreplyuseid) {
		this.tlastreplyuseid = tlastreplyuseid;
	}

	public String getTlastreplaytime() {
		return tlastreplaytime;
	}

	public void setTlastreplaytime(String tlastreplaytime) {
		this.tlastreplaytime = tlastreplaytime;
	}

	

}
