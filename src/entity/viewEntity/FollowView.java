package entity.viewEntity;

import entity.Follow;

public class FollowView extends Follow {
	public FollowView() {
		super();
	}

	public FollowView(String sname) {
		super();
		this.sname = sname;
		
	}

	public FollowView(int fid, int uid, int sid, String sname) {
		super(fid, uid, sid);
		this.sname = sname;
	}

	public FollowView(int uid, int sid, String sname) {
		super(uid, sid);
		this.sname = sname;
	}

	private String sname;

	@Override
	public String toString() {
		return "FollowView [sname=" + sname + ", fid=" + fid + ", uid=" + uid
				+ ", sid=" + sid + "]";
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
	
}
