package service.iService;

import java.util.List;

import entity.PageMode;
import entity.Topic;

/**
 * @author 锟斤拷伟锟斤拷
 * 锟斤拷锟接接匡拷
 */
public interface ITopicService {
	PageMode<Topic> queryUserAllTopic(int pageno,int pagesize,String uid);
	/**
	 * 锟斤拷询锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷topic
	 * @return
	 */
	List<Topic> queryHotsTopicList();
	/**
	 * 模锟斤拷锟斤拷询锟斤拷锟斤拷目锟斤拷锟斤拷锟斤拷
	 * @param text
	 * @return
	 */
	List<Topic> searchTopicAndContents(String text);
	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟�1
	 */
	boolean updateClickCount(String tid);
	/**
	 * 锟斤拷锟斤拷锟斤拷锟�
	 * @param sname session锟斤拷锟斤拷
	 * @param uname 锟矫伙拷锟斤拷锟斤拷
	 * @param ttopic 锟斤拷目
	 * @param tcontents 锟斤拷锟斤拷
	 * @return 锟斤拷映晒锟斤拷锟斤拷锟絫rue
	 */
	boolean addTopic(String sname,String uname,String ttopic,String tcontents);
	
	/**
	 * 锟斤拷询锟斤拷锟斤拷tsid锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷topic
	 * @param tsid session锟斤拷id
	 * @return
	 */
	List<Topic> querySameTopicListByTSID(int tsid);
	 /**
	  * 通锟斤拷tid锟斤拷询锟斤拷锟斤拷
	  * @param tid 锟斤拷锟接憋拷锟斤拷
	  * @return
	  */
	Topic queryTopicOneByTopic(int tid);
	
	
}
