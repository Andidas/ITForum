package service.iService;

import java.util.List;

import entity.PageMode;
import entity.Topic;

/**
 * @author lwy
 * topic service 
 */
public interface ITopicService {
	/**
	 * 删除topic
	 * @param tid
	 * @return
	 */
	boolean deleteTopic(String tid);
	/**
	 * 分页，用户发布的所有topic
	 * @param pageno
	 * @param pagesize
	 * @param uid
	 * @return
	 */
	PageMode<Topic> queryUserAllTopic(int pageno,int pagesize,String uid);
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
	 * 点击次数加1
	 */
	boolean updateClickCount(String tid);
	/**
	 * 发布帖子
	 */
	boolean addTopic(String sname,String uname,String ttopic,String tcontents);
	
	/**
	 * 查询相同的topic，在同一个session中
	 * @param  session id
	 * @return
	 */
	List<Topic> querySameTopicListByTSID(int tsid);
	 /**
	  * 查询单个Topic
	  * @param tid 
	  * @return
	  */
	Topic queryTopicOneByTopic(int tid);
	
	
}
