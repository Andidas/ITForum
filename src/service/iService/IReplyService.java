package service.iService;

import entity.Reply;

public interface IReplyService {
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
