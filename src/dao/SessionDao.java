package dao;

import java.util.List;

import entity.Session;
/**
 * 版块的数据库处理操作的接口
 * @author lwy
 *
 */
public interface SessionDao {
	/**
	 * 帖子数加1
	 * @param sname
	 * @return 大于0成功
	 */
	int addSessionStopiccount(String sname);
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
	int updateSessionClickCount(String sname);
	/**
	 * 通过sid查找sname
	 * @param sid
	 * @return 
	 */
	String querySessionNameBySID(int sid);
	/**
	 * 通过session名得到sid
	 * @param sname
	 * @return sid
	 */
	int querySessionIDByName(String sname);
	
	/**
	 * 查询单个版块
	 * @param sname 要查询的版块name
	 * @return 查询到得一个版块Session(all)
	 */
	Session searchSession(String sname);
	/**
	 * 查询符合的版块组，条件sprofile
	 * @return 版块组
	 */
	List<Session> querySessionByProfile(String sprofile);
}
