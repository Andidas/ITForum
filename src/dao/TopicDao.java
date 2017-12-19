package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import entity.PageMode;
import entity.PageParam;
import entity.Topic;
import entity.viewEntity.TopicView;
/**
 * 
 * @author lwy
 *
 */
public interface TopicDao {
	/**
	 * 删除topic
	 * 触发器如下：
	 * Drop TRIGGER if EXISTS t_afterdelete_on_topic;
	 * create trigger t_afterdelete_on_topic
	 * before delete on topic
	 * for each ROW
	 * begin 
	 *			delete from reply where rtid = old.tid;
	 * end;
	 * @param tid
	 * @return
	 */
	@Delete("delete from topic where tid =#{_parameter}")
	int deleteTopic(int tid);
	/**
	 * 查询用户发表过的所有topic
	 * @param page
	 * @return
	 */
	PageMode<Topic> queryUserAllTopic(PageParam page);
	
	/**
	 * 查找回帖数最多，最热门的topic
	 * @return
	 */
	List<Topic> queryHotsTopicList();
	/**
	 * 模糊查询题目和内容
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
	 * 分页视图
	 * @param page
	 * @return
	 */
	PageMode<TopicView> splitPage(PageParam page);
	/**
	 * 一共有多少条记录
	 * @param session id
	 * @return
	 */
	int rowCount(int sid);
	/**
	 * 点击次数加一
	 * @param tid
	 * @return
	 */
	int updateClickCount(int tid);
	/**
	 * 新增帖子
	 * @param 
	 * @return 
	 */
	int addTopic(Topic topic);
	
	/**
	 * 查询相同的topic，在同一个session中
	 * @return 
	 */
	List<Topic> querySameTopicListByTSID(int tsid);
	/**
	 * 查询单个Topic
	 * @param 
	 * @return
	 */
	Topic queryTopicOneByTopic(int tid);
	
	/**
	 * 回帖数加一
	 * @param tid
	 * @return
	 */
	int updateReplyCountAdd(Topic topic);
	
	/**
	 * 回帖数减一
	 * @return
	 */
	@Update("update topic set treplycount=treplycount-1 where tid=#{_parameter};")
	int updateReplyCountSub(int tid);
	/**
	 * 用户发表的帖子数
	 * @param id
	 * @return
	 */
	int rowUserTopicNum(int id);
	
	/**
	 * 分页，回复数最多的帖子
	 * @param page
	 * @return
	 */
	PageMode<TopicView> splitPageByReplyCount(PageParam page);
}
