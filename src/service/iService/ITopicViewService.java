package service.iService;

import entity.PageMode;
import entity.viewEntity.ReplyView;
import entity.viewEntity.TopicView;

public interface ITopicViewService {
	
	
	/**
	 * 查询该帖子的reply分页参数，包含所有回帖的视图
	 */
	PageMode<ReplyView> queryReplyViewPageMode(int pageno, int pagesize,int rtid);
	/**
	 * 得到单个topic view
	 */
	TopicView getTopicViewOne(String tid,String sid);
	/**
	 * 得到topic的分页视图
	 * @param pageno 第几页
	 * @param pagesize 一页需要几条数据
	 * @param tsid 
	 * @return
	 */
	PageMode<TopicView> TopicSplitPage(int pageno,int pagesize,int tsid);
	PageMode<TopicView> TopicSplitPage(int pageno, int pagesize);

}
