package service.iService;

import java.util.List;

import entity.Session;

/**
 * @author 刘伟艺
 * session版块接口
 */
public interface ISessionService {
	/**
	 * 查找session
	 * @param sname
	 * @return
	 */
	int querySessionID(String sname);
	
	/**
	 * 通过搜索栏查询到的内容
	 * @param searchText
	 * @return
	 */
	List<Session> searchSession(String searchText);
	/**
	 * 是否是查询session
	 * @param text
	 * @return
	 */
	public boolean isSearchSession(String text);
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
	 * @param sid 板块的id
	 * @return session
	 */
	Session searchSession(int sid);
	/**
	 * 查询符合的版块组，条件sprofile
	 * @param sprofile // session 主题，分类依据
	 * @param sid 
	 * @return 版块组
	 */
	
	List<Session>querySameSession(String sprofile,int sid);
	
	
	/**
	 * 点击次数加1
	 * @param sid
	 * @return
	 */
	boolean updateSessionClickCount(String sid);
	/**
	 * 新增session
	 * @param sname
	 * @param smasterid
	 * @param sprofile
	 * @param sstatement
	 * @param spicture
	 * @return
	 */
	boolean addSession(String sname, int smasterid, String sprofile,
			String sstatement, String spicture);
	
}		
 