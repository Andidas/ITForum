package entity;
/**
 * @author lwy
 * @param pageno 当前页码
 * @param pagesize 每页条数
 * @param id 用户id
 * @param friend_id 好友id
 */
public class PageParam {
	public PageParam(int pageno, int pagesize, int id, int friend_id) {
		super();
		this.pageno = pageno;
		this.pagesize = pagesize;
		this.id = id;
		this.friend_id = friend_id;
	}
	public PageParam(int pageno, int pagesize) {
		super();
		this.pageno = pageno;
		this.pagesize = pagesize;
	}
	public PageParam(int pageno, int pagesize, int id) {
		super();
		this.pageno = pageno;
		this.pagesize = pagesize;
		this.id = id;
	}
	public PageParam() {
		super();
		
	}
	private int pageno = 1;   //��ǰҳ��
	private int pagesize = 5;  //ÿҳ����
	private int id;//ģ�Ͳ���
	private int friend_id;
	
	public int getPageno() {
		return pageno;
	}
	public void setPageno(int pageno) {
		this.pageno = pageno;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFriend_id() {
		return friend_id;
	}
	public void setFriend_id(int friend_id) {
		this.friend_id = friend_id;
	}
	@Override
	public String toString() {
		return "PageParam [pageno=" + pageno + ", pagesize=" + pagesize
				+ ", id=" + id + ", friend_id=" + friend_id + "]";
	}
	
	
	
}
