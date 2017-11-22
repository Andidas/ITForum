package entity;
/**
 * @author lwy
 * @param pageno 当前页码
 * @param pagesize 每页条数
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
	private int pageno = 1;   //当前页码
	private int pagesize = 5;  //每页条数
	private int id;//模型参数
	
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
