package service.iService;


public interface IReplyService {
	/** 
	 * 发帖数加1,并且更新最后发帖人和发帖时间
	 * @param 
	 * @return
	 */
	boolean updateReplyCountAdd(int tid,int ruid,String rtime);
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
