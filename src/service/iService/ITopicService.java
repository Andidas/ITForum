package service.iService;

import java.util.List;

import entity.Topic;

/**
 * @author 刘伟艺
 * 帖子接口
 */
public interface ITopicService {
	List<Topic> searchTopicAndContents(String text);
	/**
	 * 点击次数加1
	 */
	boolean updateClickCount(String tid);
	/**
	 * 添加帖子
	 * @param sname session的名
	 * @param uname 用户的名
	 * @param ttopic 题目
	 * @param tcontents 内容
	 * @return 添加成功返回true
	 */
	boolean addTopic(String sname,String uname,String ttopic,String tcontents);
	
	/**
	 * 查询属于tsid版块的所有帖子topic
	 * @param tsid session的id
	 * @return
	 */
	List<Topic> querySameTopicListByTSID(int tsid);
	 /**
	  * 通过tid查询帖子
	  * @param tid 帖子标题
	  * @return
	  */
	Topic queryTopicOneByTopic(int tid);
	
	
}
