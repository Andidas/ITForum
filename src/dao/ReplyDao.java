package dao;

import entity.Reply;

/**
 * 跟帖的数据库处理操作的接口
 * @author lwy
 *
 */
public interface ReplyDao {
	/**
	 * 删除单个帖子
	 * @param rid
	 * @return
	 */
	int deleteReplyOne(int rid);
	
	/**
	 * 添加单个
	 * @param reply
	 * @return
	 */
	int addReplyOne(Reply reply);
}
