package dao;

import java.util.List;

import entity.Reply;

/**
 * 跟帖的数据库处理操作的接口
 * @author lwy
 *
 */
public interface ReplyDao {
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
	int deleteReplyOne(int rid);
	
	/**
	 * 添加单个
	 * @param reply
	 * @return
	 */
	int addReplyOne(Reply reply);
}
