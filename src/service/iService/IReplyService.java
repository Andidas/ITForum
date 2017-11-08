package service.iService;

import java.util.List;

import entity.Reply;

public interface IReplyService {
	/**
	 * ��ѯ�����ӵ����л���
	 * @param rtid
	 * @return
	 */
	List<Reply> queryReplyListByRTID(int rtid);
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
