package dao;

import entity.Reply;

/**
 * ���������ݿ⴦������Ľӿ�
 * @author lwy
 *
 */
public interface ReplyDao {
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
