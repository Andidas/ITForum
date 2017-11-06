package service.iService;

import java.util.List;

import entity.Session;

/**
 * @author 刘伟艺
 * session版块接口
 */
public interface ISessionService {
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
}		
 