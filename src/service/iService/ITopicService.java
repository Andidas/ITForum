package service.iService;

import java.util.List;

import entity.Topic;

/**
 * @author ��ΰ��
 * ���ӽӿ�
 */
public interface ITopicService {
	List<Topic> searchTopicAndContents(String text);
	/**
	 * ���������1
	 */
	boolean updateClickCount(String tid);
	/**
	 * �������
	 * @param sname session����
	 * @param uname �û�����
	 * @param ttopic ��Ŀ
	 * @param tcontents ����
	 * @return ��ӳɹ�����true
	 */
	boolean addTopic(String sname,String uname,String ttopic,String tcontents);
	
	/**
	 * ��ѯ����tsid������������topic
	 * @param tsid session��id
	 * @return
	 */
	List<Topic> querySameTopicListByTSID(int tsid);
	 /**
	  * ͨ��tid��ѯ����
	  * @param tid ���ӱ���
	  * @return
	  */
	Topic queryTopicOneByTopic(int tid);
	
	
}
