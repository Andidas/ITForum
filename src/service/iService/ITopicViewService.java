package service.iService;

import entity.PageMode;
import entity.ReplyView;
import entity.TopicView;

public interface ITopicViewService {
	/**
	 * ��ѯ�����ӵ�reply��ҳ�������������л�������ͼ
	 */
	PageMode<ReplyView> queryReplyViewPageMode(int pageno, int pagesize,int rtid);
	/**
	 * �õ�����topic view
	 */
	TopicView getTopicViewOne(String tid,String sid);
	/**
	 * �õ�topic�ķ�ҳ��ͼ
	 */
	PageMode<TopicView> TopicSplitPage(int pageno,int pagesize,int tsid);
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
	String neatenSessionContentInit(String tcontents);
}
