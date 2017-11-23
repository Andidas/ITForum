package service.iService;

/**
 * @author lwy
 * 关注服务接口
 */
public interface IFollowService {
	/**
	 * session是否被user关注
	 * @param uid
	 * @param sid
	 * @return
	 */
	boolean isBeFollow(String uid,String sid);
	/**
	 * 查询版块的关注人数
	 * @param sid
	 * @return
	 */
	int queryFollowCount(int sid);
	/**
	 * @param uname
	 * @param sname
	 * @return 关注成功为true
	 */
	boolean addFollow(String uname,String sname);
	/**
	 * @param uname
	 * @param sname
	 * @return 取消关注成功为true
	 */
	boolean deleteFollow(String uname,String sname);
}
