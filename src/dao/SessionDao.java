package dao;

import entity.Session;
/**
 * 版块的数据库处理操作的接口
 * @author lwy
 *
 */
public interface SessionDao {
	/**
	 * 增加版块
	 * @param Session 要增加的版块 (sname,smasterid)
	 * @return 返回被增加的条数，如果不大于0则表示失败
	 */
	int addSession(Session Session);
	/**
	 * 删除版块
	 * @param sid 版块的id
	 * @return 返回被删除的条数，如果不大于0则表示失败
	 */
	int delSession(String sname);
	/**
	 * 修改版块
	 * @param Session 要修改的版块
	 * @return 返回被更新的条数，如果不大于0则表示失败
	 */
	int modifySession(Session Session);
	/**
	 * 查询单个版块
	 * @param sname 要查询的版块name
	 * @return 查询到得一个版块Session(all)
	 */
	Session searchSession(String sname);
	/**
	 * 查询所有的版块
	 * @return 版块组
	 */
}
