package dao;

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
	 * 符合条件的条数
	 * @param topic的id
	 * @return
	 */
	int rowCount(int id);
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
}
