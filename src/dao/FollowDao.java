package dao;

import entity.Follow;

public interface FollowDao {
	/**
	 * ���follow
	 * @param follow
	 * @return ���ر����ӵ����������������0���ʾʧ��
	 */
	int addFollow(Follow follow);
	/**
	 * ɾ��
	 * @param fid
	 * @return ���ر����ӵ����������������0���ʾʧ��
	 */
	int deleteFollow(int fid);
	/**
	 * ͨ�� uid ��sid ��ѯfid
	 * @param follow
	 * @return fid
	 */
	public abstract int queryFollowID(Follow follow);
}
