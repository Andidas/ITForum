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
	 * ��������
	 * @param Topic Ҫ���ӵ����� (tsid,tuid,ttopic,tcontents,ttime)
	 * @return ���ر����ӵ����������������0���ʾʧ��
	 */
	int addTopic(Topic topic);
	/**
	 * ɾ������
	 * @param tid ������id
	 * @return ���ر�ɾ�������������������0���ʾʧ��
	 */
	int delTopic(int tid);
	/**
	 * �޸�����
	 * @param Topic Ҫ�޸ĵ�����
	 * @return ���ر����µ����������������0���ʾʧ��
	 */
	int modifyTopic(Topic topic);
	/**
	 * ��ѯ��������
	 * @param uemail Ҫ��ѯ������email
	 * @return ��ѯ����һ������Topic(all)
	 */
	Topic queryTopic(int tid);
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
}
