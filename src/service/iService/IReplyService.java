package service.iService;

import java.util.List;

import entity.PageMode;
import entity.Reply;
import entity.ReplyView;

public interface IReplyService {
	/** 
	 * ��������1,���Ҹ���������˺ͷ���ʱ��
	 * @param 
	 * @return
	 */
	boolean updateReplyCountAdd(int tid,int ruid,String rtime);
	
	
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
