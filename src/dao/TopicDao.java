package dao;

import java.util.List;

import entity.PageMode;
import entity.PageParam;
import entity.Topic;
import entity.TopicView;
/**
 * ���������ݿ⴦������Ľӿ�
 * @author lwy
 *
 */


public interface TopicDao {
	/**
	 * ��ѯ����topic view
	 * @param ttopic
	 * @return
	 */
	TopicView getTopicViewOne(String ttopic);
	/**
	 * ���ڷ�ҳ
	 * @param page
	 * @return
	 */
	PageMode<TopicView> splitPage(PageParam page);
	/**
	 * �ж�������¼
	 * @param sid��ѯ��session id
	 * @return
	 */
	int rowCount(int sid);
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
	List<Topic> querySameTopicListByTSID(int tsid);
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
