package dao;

import org.apache.ibatis.annotations.Delete;

import entity.PageMode;
import entity.PageParam;
import entity.Reply;
import entity.viewEntity.ReplyView;

/**
 * 跟帖的数据库处理操作的接口
 * @author lwy
 *
 */
public interface ReplyDao {
	/**
	 * 删除reply
	 * @param rid
	 * @return
	 */
	@Delete("delete from reply where rid = #{_parameter}")
	int deleteReply(int rid);
	/**
	 * 查询该用户的所有回复
	 * @param uid 用户id
	 * @return
	 */
	PageMode<Reply> queryUserAllReply(PageParam pageParam);
	/**
	 * 符合条件的条数
	 * @param topic的id
	 * @return
	 */
	int ReplyrowNum(int id);
	/**
	 * 回帖的分页视图列表
	 * @param rtid 查询条件
	 * @return
	 */
	PageMode<ReplyView> queryReplyViewList(PageParam pageParam);
	
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
	
	/**
	 * 用户回复的帖子数
	 * @param userid
	 * @return
	 */
	int UserReplyrowNum(int userid);
}