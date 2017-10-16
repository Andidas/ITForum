package dao;

import entity.Reply;

/**
 * 跟帖的数据库处理操作的接口
 * @author lwy
 *
 */
public interface ReplyDao {
	/**
	 * 增加跟帖
	 * @param Reply 要增加的跟帖 (rid,tsid,tuid,tReply,tcontents,ttime)
	 * @return 返回被增加的条数，如果不大于0则表示失败
	 */
	int addReply(Reply reply);
	/**
	 * 删除跟帖
	 * @param rid 跟帖的id
	 * @return 返回被删除的条数，如果不大于0则表示失败
	 */
	int delReply(int rid);
	/**
	 * 修改跟帖
	 * @param Reply 要修改的跟帖
	 * @return 返回被更新的条数，如果不大于0则表示失败
	 */
	int modifyReply(Reply reply);
	/**
	 * 查询单个跟帖
	 * @param rid 要查询的跟帖id
	 * @return 查询到得一个跟帖Reply(all)
	 */
	Reply searchReply(int rid);
	/**
	 * 查询所有的跟帖
	 * @return 跟帖组
	 */
}
