package dao;

import java.util.List;

import entity.Follow;
import entity.viewEntity.FollowView;

/**
 * @author lwy
 *	关注和取消关注的Dao类
 */
public interface FollowDao {
	/**
	 * 查找该用户关注的session
	 * @param uid 用户id
	 * @return
	 */
	List<FollowView>queryFollowList(int uid);
	/**
	 * 是否被该用户关注
	 * @param follow
	 * @return
	 */
	int isBeFollow(Follow follow);
	/**
	 * 查询session的关注人数
	 * @param sid
	 * @return
	 */
	int queryFollowCount(int sid);
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
