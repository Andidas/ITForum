package dao;

import java.util.List;

import entity.Session;
import entity.viewEntity.SessionView;
/**
 * 版块的数据库处理操作的接口
 * @author lwy
 *
 */
public interface SessionDao {
	/**
	 * 查找session的id
	 * @param sname
	 * @return
	 */
	int querySessionID(String sname);
	/**
	 * 增加一个session
	 * @param session
	 * @return
	 */
	int insertSession(Session session);
	/**
	 * 查询session view
	 * @param sid
	 * @return
	 */
	SessionView querySessionView(int sid);
	/**
	 * 帖子数加1
	 * @param sid
	 * @return 大于0成功
	 */
	int addSessionStopiccount(int sid);
	/**
	 * 帖子数减1
	 * @param sname
	 * @return 大于0成功
	 */
	int subSessionStopiccount(String sname);
	/**
	 * 查询帖子数
	 * @param sname
	 * @return 返回帖子的数目
	 */
	int querySessionStopicCount(String sname);
	
	/**
	 * 点击次数加1
	 * @param sname
	 * @return 大于0成功
	 */
	int updateSessionClickCount(int sid);

	
	/**
	 * 查询单个版块
	 * @param sid 要查询的版块sid
	 * @return 查询到得一个版块Session(all)
	 */
	Session searchSession(int sid);
	/**
	 * 查询符合的相似版块组，条件sprofile 和sid
	 * 不包括传进来的session本身
	 * @return 版块组
	 */
	List<Session> querySameSession(Session session);
	/**
	 * 通过搜索栏查找session
	 * @param searchText
	 * @return
	 */
	List<Session> searchSession(String searchText);
	

	
	
}
