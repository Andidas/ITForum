package dao;

import java.util.List;

import entity.Reply;

/**
 * ���������ݿ⴦������Ľӿ�
 * @author lwy
 *
 */
public interface ReplyDao {
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
	int deleteReplyOne(int rid);
	
	/**
	 * ��ӵ���
	 * @param reply
	 * @return
	 */
	int addReplyOne(Reply reply);
}
