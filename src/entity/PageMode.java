package entity;

import java.util.ArrayList;
import java.util.List;
/**
 * @author lwy
 * @param data //List<T>
 * @param pageParam
 * @param totalRecordCount �ܼ�¼��
 * @param totalPageCount ��ҳ��
 */
public class PageMode<T> {
	
	
	private List<T> data = new ArrayList<T>();   //ÿҳ��������
	private PageParam pageParam;
	private int totalRecordCount;   //�ܼ�¼��
	private int totalPageCount;  //��ҳ��
	
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
