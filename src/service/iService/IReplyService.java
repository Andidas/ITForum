package service.iService;

import java.util.List;

import entity.Reply;

public interface IReplyService {
	/**
	 * 查询该帖子的所有回帖
	 * @param rtid
	 * @return
	 */
	List<Reply> queryReplyListByRTID(int rtid);
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
