package dao;

import entity.Topic;
/**
 * 主贴的数据库处理操作的接口
 * @author lwy
 *
 */


public interface TopicDao {
	/**
	 * 增加主贴
	 * @param Topic 要增加的主贴 (tid,tsid,tuid,ttopic,tcontents,ttime)
	 * @return 返回被增加的条数，如果不大于0则表示失败
	 */
	int addTopic(Topic topic);
	/**
	 * 删除主贴
	 * @param tid 主贴的id
	 * @return 返回被删除的条数，如果不大于0则表示失败
	 */
	int delTopic(int tid);
	/**
	 * 修改主贴
	 * @param Topic 要修改的主贴
	 * @return 返回被更新的条数，如果不大于0则表示失败
	 */
	int modifyTopic(Topic topic);
	/**
	 * 查询单个主贴
	 * @param uemail 要查询的主贴email
	 * @return 查询到得一个主贴Topic(all)
	 */
	Topic searchTopic(int tid);
	/**
	 * 查询所有的主贴
	 * @return 主贴组
	 */
}
