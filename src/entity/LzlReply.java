package entity;

/**
 * @author lwy
 * @param lid 楼中楼id
 * @param lrid 回帖id
 * @param luid 回帖用户id
 * @param lcontent 内容id
 * @param ltime 回复时间
 */
public class LzlReply {
	public LzlReply(int lrid, int luid, String lcontent, String ltime) {
		super();
		this.lrid = lrid;
		this.luid = luid;
		this.lcontent = lcontent;
		this.ltime = ltime;
	}
	public LzlReply() {
		super();
	}
	public LzlReply(int lid, int lrid, int luid, String lcontent, String ltime) {
		super();
		this.lid = lid;
		this.lrid = lrid;
		this.luid = luid;
		this.lcontent = lcontent;
		this.ltime = ltime;
	}
	private int lid;
	private int lrid;
	private int luid;
	private String lcontent;
	private String ltime;
	@Override
	public String toString() {
		return "lzlReply [lid=" + lid + ", lrid=" + lrid + ", luid=" + luid
				+ ", lcontent=" + lcontent + ", ltime=" + ltime + "]";
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getLrid() {
		return lrid;
	}
	public void setLrid(int lrid) {
		this.lrid = lrid;
	}
	public int getLuid() {
		return luid;
	}
	public void setLuid(int luid) {
		this.luid = luid;
	}
	public String getLcontent() {
		return lcontent;
	}
	public void setLcontent(String lcontent) {
		this.lcontent = lcontent;
	}
	public String getLtime() {
		return ltime;
	}
	public void setLtime(String ltime) {
		this.ltime = ltime;
	}
}
