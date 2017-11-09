package service.iService;

import java.util.List;

import entity.PageMode;
import entity.PageParam;
import entity.ReplyView;
import entity.Topic;
import entity.TopicView;

/**
 * @author ��ΰ��
 * ���ӽӿ�
 */
public interface ITopicService {
	/**
	 * ��ѯ�����ӵķ�ҳ�������������л�������ͼ
	 * @param 
	 * @return
	 */
	PageMode<ReplyView> queryReplyViewPageMode(int pageno, int pagesize,int rtid);
	/**
	 * �õ�����topic view
	 * @param topicTName
	 * @param sid
	 * @return
	 */
	TopicView getTopicViewOne(String topicTName,String sid);
	/**
	 * �õ�topic�ķ�ҳ��ͼ
	 * @param pageno
	 * @param pagesize
	 * @param tsid
	 * @return
	 */
	PageMode<TopicView> TopicSplitPage(int pageno,int pagesize,int tsid);
	
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
	 List<Topic> querySameTopicListByTSID(int tsid);
	 /**
		 * ͨ�������ѯ����
		 * @param ttopic ���ӱ���
		 * @return
		 */
	Topic queryTopicOneByTopic(String ttopic);
	
}
