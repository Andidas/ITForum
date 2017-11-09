package service.iService;

import java.util.List;

import entity.PageMode;
import entity.Reply;
import entity.ReplyView;

public interface IReplyService {
	/**
	 * ��ѯ�����ӵķ�ҳ�������������л�������ͼ
	 * @param 
	 * @return
	 */
	PageMode<ReplyView> queryReplyViewPageMode(int pageno, int pagesize,int tsid);
	
	/**
	 * ɾ����������
	 * @param rid
	 * @return
	 */
	boolean deleteReplyOne(int rid);
	
	/**
	 * ��ӵ���
	 * @param 
	 * @return
	 */
	boolean addReplyOne(String nowTopicTid,String nowSessionID,String nowUserID,String replyText);
}
