package dao;

import java.util.List;

import entity.PageMode;
import entity.PageParam;
import entity.Topic;
import entity.viewEntity.TopicView;
/**
 * 主贴的数据库处理操作的接口
 * @author lwy
 *
 */


public interface TopicDao {
	/**
	 * 查询回帖数最多的topic
	 * @return
	 */
	List<Topic> queryHotsTopicList();
	/**
	 * 搜索帖子，由题目和内容
	 * @param text
	 * @return
	 */
	List<Topic> searchTopicAndContents(String text);
	/**
	 * 查询单个topic view
	 * @param tid
	 * @return
	 */
	TopicView getTopicViewOne(int tid);
	/**
	 * 用于分页
	 * @param page
	 * @return
	 */
	PageMode<TopicView> splitPage(PageParam page);
	/**
	 * 有多少条记录
	 * @param sid查询的session id
	 * @return
	 */
	int rowCount(int sid);
	/**
	 * 点击次数加1
	 * @param tid
	 * @return
	 */
	int updateClickCount(int tid);
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
	List<Topic> querySameTopicListByTSID(int tsid);
	/**
	 * 通过标题查询帖子
	 * @param tid 帖子id
	 * @return
	 */
	Topic queryTopicOneByTopic(int tid);
	
	/**
	 * 回帖数加1
	 * @param tid
	 * @return
	 */
	int updateReplyCountAdd(Topic topic);
}
