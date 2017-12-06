package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

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
	@Select("select f.fid,f.uid,f.sid,s.sname from follow f left join `session` s on  f.sid = s.sid where uid =#{_parameter}")
	List<FollowView>queryFollowList(int uid);
	/**
	 * 是否被该用户关注
	 * @param follow
	 * @return
	 */
	@Select("select count(fid) nun from follow  where uid =#{uid} and sid = #{sid}")
	int isBeFollow(Follow follow);
	/**
	 * 查询session的关注人数
	 * @param sid
	 * @return
	 */
	@Select("select count(fid) as count from follow where sid = #{_parameter}")
	int queryFollowCount(int sid);
	/**
	 * 添加follow
	 * @param follow
	 * @return 返回被增加的条数，如果不大于0则表示失败
	 */
	@Insert("insert into follow(uid,sid) VALUES(#{uid},#{sid});")
	int addFollow(Follow follow);
	/**
	 * 删除
	 * @param fid
	 * @return 返回被增加的条数，如果不大于0则表示失败
	 */
	@Delete("delete from follow  where uid = #{uid} and sid = #{sid}")
	int deleteFollow(Follow follow);
	
}