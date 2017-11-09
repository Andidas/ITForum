package service.iService;

import java.util.List;

import entity.PageMode;
import entity.Reply;
import entity.ReplyView;

public interface IReplyService {
	/**
	 * 查询该帖子的分页参数，包含所有回帖的视图
	 * @param 
	 * @return
	 */
	PageMode<ReplyView> queryReplyViewPageMode(int pageno, int pagesize,int tsid);
	
	/**
	 * 删除单个帖子
	 * @param rid
	 * @return
	 */
	boolean deleteReplyOne(int rid);
	
	/**
	 * 添加单个
	 * @param 
	 * @return
	 */
	boolean addReplyOne(String nowTopicTid,String nowSessionID,String nowUserID,String replyText);
}
