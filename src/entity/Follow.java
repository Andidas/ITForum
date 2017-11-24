package entity;
/**
 * @author lwy
 * ��ע��ʵ����
 * @param fid ��ע��id���Զ�����
 * @param uid �û�id
 * @param sid session��id
 */
public class Follow {
	
	public Follow(int uid, int sid) {
		super();
		this.uid = uid;
		this.sid = sid;
	}
	public Follow(int fid, int uid, int sid) {
		super();
		this.fid = fid;
		this.uid = uid;
		this.sid = sid;
	}
	public Follow() {
		super();
		
	}
	protected int fid;
	protected int uid;
	protected int sid;
	@Override
	public String toString() {
		return "Follow [fid=" + fid + ", uid=" + uid + ", sid=" + sid + "]";
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
}
