package service.iService;

import entity.PageMode;
import entity.viewEntity.ReplyView;
import entity.viewEntity.TopicView;

public interface ITopicViewService {
	
	
	/**
	 * ��ѯ�����ӵ�reply��ҳ�������������л�������ͼ
	 */
	PageMode<ReplyView> queryReplyViewPageMode(int pageno, int pagesize,int rtid);
	/**
	 * �õ�����topic view
	 */
	TopicView getTopicViewOne(String tid,String sid);
	/**
	 * �õ�topic�ķ�ҳ��ͼ
	 * @param pageno �ڼ�ҳ
	 * @param pagesize һҳ��Ҫ��������
	 * @param tsid 
	 * @return
	 */
	PageMode<TopicView> TopicSplitPage(int pageno,int pagesize,int tsid);
	PageMode<TopicView> TopicSplitPage(int pageno, int pagesize);

}
