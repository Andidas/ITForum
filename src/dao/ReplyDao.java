package dao;

import entity.Reply;

/**
 * ���������ݿ⴦������Ľӿ�
 * @author lwy
 *
 */
public interface ReplyDao {
	/**
	 * ���Ӹ���
	 * @param Reply Ҫ���ӵĸ��� (rid,tsid,tuid,tReply,tcontents,ttime)
	 * @return ���ر����ӵ����������������0���ʾʧ��
	 */
	int addReply(Reply reply);
	/**
	 * ɾ������
	 * @param rid ������id
	 * @return ���ر�ɾ�������������������0���ʾʧ��
	 */
	int delReply(int rid);
	/**
	 * �޸ĸ���
	 * @param Reply Ҫ�޸ĵĸ���
	 * @return ���ر����µ����������������0���ʾʧ��
	 */
	int modifyReply(Reply reply);
	/**
	 * ��ѯ��������
	 * @param rid Ҫ��ѯ�ĸ���id
	 * @return ��ѯ����һ������Reply(all)
	 */
	Reply searchReply(int rid);
	/**
	 * ��ѯ���еĸ���
	 * @return ������
	 */
}
