package service.iService;

import entity.Reply;

public interface IReplyService {
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
