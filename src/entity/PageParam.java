package entity;
/**
 * @author lwy
 * @param pageno ��ǰҳ��
 * @param pagesize ÿҳ����
 * @param id 
 */
public class PageParam {
	
	
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
	@Override
	public String toString() {
		return "PageParam [pageno=" + pageno + ", pagesize=" + pagesize
				+ ", id=" + id + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
