package service.iService;

import java.util.List;

import entity.Topic;

/**
 * @author ��ΰ��
 * ���ӽӿ�
 */
public interface ITopicService {
	/**
	 * ���������1
	 * @param ttopic
	 * @return
	 */
	boolean updateClickCount(String ttopic);
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
	 * ���ϴ����������������������Ű棬����ʾ��session������֮��
	 * �����������Ű棺
	 * <p>��������</p>
	 * <img/><img/><img/>(ps : �����ʾ����ͼƬ)
	 * 
	 * @param uname ����
	 * @param ttopic ������Ŀ
	 * @param tcontents ��������
	 * @return �µ��Ű�
	 */
	 String neatenSessionContent(String uname,String ttopic,String tcontents);
	/**
	 * ��ѯ����tsid������������topic
	 * @param tsid session��id
	 * @return
	 */
	 List<Topic> queryTopicListByTSID(int tsid);
	 /**
		 * ͨ�������ѯ����
		 * @param ttopic ���ӱ���
		 * @return
		 */
	Topic queryTopicOneByTopic(String ttopic);
	
}
