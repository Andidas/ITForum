package dao;

import entity.Follow;

public interface FollowDao {
	/**
	 * 添加follow
	 * @param follow
	 * @return 返回被增加的条数，如果不大于0则表示失败
	 */
	int addFollow(Follow follow);
	/**
	 * 删除
	 * @param fid
	 * @return 返回被增加的条数，如果不大于0则表示失败
	 */
	int deleteFollow(int fid);
	/**
	 * 通过 uid 和sid 查询fid
	 * @param follow
	 * @return fid
	 */
	public abstract int queryFollowID(Follow follow);
}
