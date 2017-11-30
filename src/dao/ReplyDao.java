package dao;

import entity.PageMode;
import entity.PageParam;
import entity.Reply;
import entity.viewEntity.ReplyView;

/**
 * ���������ݿ⴦������Ľӿ�
 * @author lwy
 *
 */
public interface ReplyDao {
	/**
	 * ��ѯ���û������лظ�
	 * @param uid �û�id
	 * @return
	 */
	PageMode<Reply> queryUserAllReply(PageParam pageParam);
	/**
	 * ��������������
	 * @param topic��id
	 * @return
	 */
	int ReplyrowNum(int id);
	/**
	 * �����ķ�ҳ��ͼ�б�
	 * @param rtid ��ѯ����
	 * @return
	 */
	PageMode<ReplyView> queryReplyViewList(PageParam pageParam);
	
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
