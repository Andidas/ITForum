package dao;

import java.util.List;

import entity.PageMode;
import entity.PageParam;
import entity.Reply;
import entity.ReplyView;

/**
 * ���������ݿ⴦������Ľӿ�
 * @author lwy
 *
 */
public interface ReplyDao {
	/**
	 * ��������������
	 * @param topic��id
	 * @return
	 */
	int rowCount(int id);
	/**
	 * ��������ͼ�б�
	 * @param rtid ��ѯ����
	 * @return
	 */
	PageMode<ReplyView> queryReplyViewListByRTID(PageParam pageParam);
	
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
