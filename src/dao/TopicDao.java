package dao;

import java.util.List;

import entity.PageMode;
import entity.PageParam;
import entity.Topic;
import entity.viewEntity.TopicView;
/**
 * ���������ݿ⴦������Ľӿ�
 * @author lwy
 *
 */


public interface TopicDao {
	PageMode<Topic> queryUserAllTopic(PageParam page);
	
	/**
	 * ��ѯ����������topic
	 * @return
	 */
	List<Topic> queryHotsTopicList();
	/**
	 * �������ӣ�����Ŀ������
	 * @param text
	 * @return
	 */
	List<Topic> searchTopicAndContents(String text);
	/**
	 * ��ѯ����topic view
	 * @param tid
	 * @return
	 */
	TopicView getTopicViewOne(int tid);
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
	 * @param tid
	 * @return
	 */
	int updateClickCount(int tid);
	/**
	 * ��������
	 * @param Topic Ҫ���ӵ����� (tsid,tidy,ttopic,tcontents,ttime)
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
	 * @param tid ����id
	 * @return
	 */
	Topic queryTopicOneByTopic(int tid);
	
	/**
	 * ��������1
	 * @param tid
	 * @return
	 */
	int updateReplyCountAdd(Topic topic);
}
