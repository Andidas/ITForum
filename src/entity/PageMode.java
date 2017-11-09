package entity;

import java.util.ArrayList;
import java.util.List;
/**
 * @author lwy
 * @param data //List<T>
 * @param pageParam
 * @param totalRecordCount 总记录数
 * @param totalPageCount 总页数
 */
public class PageMode<T> {
	
	
	private List<T> data = new ArrayList<T>();   //每页数据内容
	private PageParam pageParam;
	private int totalRecordCount;   //总记录数
	private int totalPageCount;  //总页数
	
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	public int getTotalRecordCount() {
		return totalRecordCount;
	}
	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}
	public int getTotalPageCount() {
		if(totalRecordCount%pageParam.getPagesize()==0){
			totalPageCount = totalRecordCount/pageParam.getPagesize();
		}else{
			totalPageCount = totalRecordCount/pageParam.getPagesize()+1;
		}
		return totalPageCount;
	}
	public PageParam getPageParam() {
		return pageParam;
	}
	public void setPageParam(PageParam pageParam) {
		this.pageParam = pageParam;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	@Override
	public String toString() {
		return "PageMode [data=" + data + ", pageParam=" + pageParam
				+ ", totalRecordCount=" + totalRecordCount
				+ ", totalPageCount=" + totalPageCount + "]";
	}
	
}
