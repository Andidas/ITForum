package service.iService;

import java.util.List;

import entity.Session;

/**
 * @author 刘伟艺
 * session版块接口
 */
public interface ISessionService {
	/**
	 * 帖子数加1
	 * @param sname
	 * @return 成功,返回true
	 */
	boolean addSessionStopiccount(String sname);
	/**
	 * 帖子数减1
	 * @param sname
	 * @return 成功,返回true
	 */
	boolean subSessionStopiccount(String sname);
	/**
	 * 查询帖子数
	 * @param sname
	 * @return 返回帖子的数目
	 */
	int querySessionStopicCount(String sname);
	/**
	 * 查询整个板块的信息
	 * @param sname 板块的名字
	 * @return session
	 */
	Session searchSession(String sname);
	/**
	 * 查询符合的版块组，条件sprofile
	 * @return 版块组
	 */
	List<Session>querySessionByProfile(String sprofile);
	
	/**
	 * 通过sid查找sname
	 * @param sid
	 * @return
	 */
	String querySessionNameBySID(int sid);
	/**
	 * 点击次数加1
	 * @param sname
	 * @return
	 */
	boolean updateSessionClickCount(String sname);
}		
 