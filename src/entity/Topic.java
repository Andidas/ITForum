package entity;



/**
 * @author lwy
 * 
 * @param tid  ������ID
 * @param tsid ���ڰ��,���(���ð����SID)
 * @param tuid ������,���(���� �û����UID)
 * @param treplycount �ظ���
 * @param temotion �������� 
 * @param ttopic ���� 
 * @param tcontents ���� 
 * @param ttime ����ʱ��
 * @param tclickcount �����
 * @param tflag ״̬ 
 * @param tlastreplyuseid ���ظ��û�ID,���(�����û����UID)
 * @param tlastreplaytime ���ظ�ʱ��
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

	private int tid;// ������ID
	private int tsid;// ���ڰ��,���(���ð����SID)
	private int tuid;// ������,���(�����û����UID)
	private int treplycount;// �ظ���
	private String temotion;// �������� 
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
