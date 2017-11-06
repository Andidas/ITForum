package service.iService;

/**
 * @author lwy
 * 关注服务接口
 */
public interface IFollowService {
	/**
	 * 
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
