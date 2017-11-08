package dao;

import java.util.List;

import entity.Topic;
/**
 * 主贴的数据库处理操作的接口
 * @author lwy
 *
 */


public interface TopicDao {
	
	/**
	 * 点击次数加1
	 * @param ttopic
	 * @return
	 */
	int updateClickCount(String ttopic);
	/**
	 * 增加主贴
	 * @param Topic 要增加的主贴 (tsid,tuid,ttopic,tcontents,ttime)
	 * @return 返回被增加的条数，如果不大于0则表示失败
	 */
	int addTopic(Topic topic);
	
	/**
	 * 查询符合的主贴,过滤条件tsid
	 * @return 主贴组
	 */
	List<Topic> queryTopicListByTSID(int tsid);
	/**
	 * 通过标题查询帖子
	 * @param ttopic 帖子标题
	 * @return
	 */
	Topic queryTopicOneByTopic(String ttopic);
	
	/**
	 * 回帖数加1
	 * @param tid
	 * @return
	 */
	int updateReplyCountAdd(Topic topic);
}
