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
	 * @param tsid 过滤参数，session id
	 * @return
	 */
	PageMode<TopicView> TopicSplitPage(int pageno,int pagesize,int tsid);
	/**
	 * 得到topic的分页视图
	 * @param pageno 第几页
	 * @param pagesize 一页需要几条数据
	 * @return
	 */
	PageMode<TopicView> TopicSplitPage(int pageno, int pagesize);
	
	/**
	 * 得到topic的分页视图,按照回复条数最多来分页
	 * @param pageno 第几页
	 * @param pagesize 一页需要几条数据
	 * @return
	 */
	PageMode<TopicView> splitPageByReplyCount(int pageno, int pagesize);

}
