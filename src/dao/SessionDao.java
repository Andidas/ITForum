package dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import entity.Session;
import entity.viewEntity.SessionView;
/**
 * �������ݿ⴦������Ľӿ�
 * @author lwy
 *
 */
public interface SessionDao {
	/**
	 * ��ѯ���е�session����profile
	 * @return
	 */
	@Select("select DISTINCT sprofile from session")
	List <String>queryAllProfile();
	/**
	 * ����session��id
	 * @param sname
	 * @return
	 */
	@Select("select sid from session where sname=#{_parameter}")
	int querySessionID(String sname);
	/**
	 * ����һ��session
	 * @param session
	 * @return
	 */
	@Insert("insert into session values(null,#{sname},#{smasterid},#{sprofile},#{sstatement},#{stopiccount},#{sclickcount},#{spicture})")
	int insertSession(Session session);
	/**
	 * ��ѯsession view
	 * @param sid
	 * @return
	 */
	@Select("select s.*,u.uname from `session` s,`user` u where s.smasterid = u.uid and sid = #{_parameter}")
	SessionView querySessionView(int sid);
	/**
	 * ��������1
	 * @param sid
	 * @return ����0�ɹ�
	 */
	@Update("UPDATE `session` set stopiccount = stopiccount+1 where sid= #{_parameter}")
	int addSessionStopiccount(int sid);
	/**
	 * ��������1
	 * @param sname
	 * @return ����0�ɹ�
	 */
	@Update("UPDATE `session` set stopiccount = stopiccount-1 where sname= #{_parameter}")
	int subSessionStopiccount(String sname);
	/**
	 * ��ѯ������
	 * @param sname
	 * @return �������ӵ���Ŀ
	 */
	@Select("select stopiccount from `session` where sname=#{_parameter}")
	int querySessionStopicCount(String sname);
	
	/**
	 * ���������1
	 * @param sname
	 * @return ����0�ɹ�
	 */
	@Update("UPDATE `session` set sclickcount = sclickcount+1 where sid= #{_parameter}")
	int updateSessionClickCount(String sid);

	
	/**
	 * ��ѯ�������
	 * @param sid Ҫ��ѯ�İ��sid
	 * @return ��ѯ����һ�����Session(all)
	 */
	@Select("select * from session where sname like CONCAT(CONCAT('%', #{_parameter}), '%')")
	Session searchSessionBySid(int sid);
	/**
	 * ��ѯ���ϵ����ư���飬����sprofile ��sid
	 * ��������������session����
	 * @return �����
	 */
	@Select("select sid,sname,sstatement from `session` where sprofile=#{sprofile} and sid <> #{sid} order by sclickcount DESC limit 0,5")
	List<Session> querySameSession(Session session);
	
	/**
	 * ��ѯ����ͬһ���session
	 * @param sprofile
	 * @return
	 */
	@Select("select sid,sname from `session` where sprofile =#{_parameter}")
	List<Session> queryAllSessionByProfile(String sprofile);
	/**
	 * ͨ������������session
	 * @param searchText
	 * @return
	 */
	@Select("select * from session where sname like CONCAT(CONCAT('%', #{_parameter}), '%')")
	List<Session> searchSession(String searchText);
	

	
	
}
