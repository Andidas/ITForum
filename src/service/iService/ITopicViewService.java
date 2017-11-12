package service.iService;

import java.util.List;

import entity.PageMode;
import entity.viewEntity.ReplyView;
import entity.viewEntity.TopicView;

public interface ITopicViewService {
	
	/**
	 * ���ͼ���src 
	 * @param tcontents
	 * @return
	 */
	List<String> getImageAndContent(String tcontents);
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
	 * @param pageno �ڼ�ҳ
	 * @param pagesize һҳ��Ҫ��������
	 * @param tsid 
	 * @return
	 */
	PageMode<TopicView> TopicSplitPage(int pageno,int pagesize,int tsid);
	/**
	 * ���ϴ����������������������Ű棬����ʾ��session������֮��
	 * �����������Ű棺
	 * <p>��������</p>
	 * <img/><img/><img/>(ps : �����ʾ����ͼƬ)
	 * 
	 * ��������<p></p>��������ݣ���ͼƬ��������
	 *
	 * @param tcontents ��������
	 * @return �µ��Ű�
	 */
	String neatenSessionContentInit(String tcontents);
}
