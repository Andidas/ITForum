package dao;

import entity.Topic;



public interface TopicDao {
	/**
	 * ��������
	 * @param Topic Ҫ���ӵ����� (sname,smasterid)
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
	Topic searchTopic(int tid);
	/**
	 * ��ѯ���е�����
	 * @return ������
	 */
}
