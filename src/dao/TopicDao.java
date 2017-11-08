package dao;

import java.util.List;

import entity.Topic;
/**
 * ���������ݿ⴦������Ľӿ�
 * @author lwy
 *
 */


public interface TopicDao {
	
	/**
	 * ���������1
	 * @param ttopic
	 * @return
	 */
	int updateClickCount(String ttopic);
	/**
	 * ��������
	 * @param Topic Ҫ���ӵ����� (tsid,tuid,ttopic,tcontents,ttime)
	 * @return ���ر����ӵ����������������0���ʾʧ��
	 */
	int addTopic(Topic topic);
	
	/**
	 * ��ѯ���ϵ�����,��������tsid
	 * @return ������
	 */
	List<Topic> queryTopicListByTSID(int tsid);
	/**
	 * ͨ�������ѯ����
	 * @param ttopic ���ӱ���
	 * @return
	 */
	Topic queryTopicOneByTopic(String ttopic);
	
	/**
	 * ��������1
	 * @param tid
	 * @return
	 */
	int updateReplyCountAdd(Topic topic);
}
