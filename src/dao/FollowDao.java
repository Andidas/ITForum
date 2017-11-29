package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import entity.Follow;
import entity.viewEntity.FollowView;

/**
 * @author lwy
 *	��ע��ȡ����ע��Dao��
 */
public interface FollowDao {
	/**
	 * ���Ҹ��û���ע��session
	 * @param uid �û�id
	 * @return
	 */
	@Select("select f.fid,f.uid,f.sid,s.sname from follow f left join `session` s on  f.sid = s.sid where uid =#{_parameter}")
	List<FollowView>queryFollowList(int uid);
	/**
	 * �Ƿ񱻸��û���ע
	 * @param follow
	 * @return
	 */
	@Select("select count(fid) nun from follow  where uid =#{uid} and sid = #{sid}")
	int isBeFollow(Follow follow);
	/**
	 * ��ѯsession�Ĺ�ע����
	 * @param sid
	 * @return
	 */
	@Select("select count(fid) as count from follow where sid = #{_parameter}")
	int queryFollowCount(int sid);
	/**
	 * ���follow
	 * @param follow
	 * @return ���ر����ӵ����������������0���ʾʧ��
	 */
	@Insert("insert into follow(uid,sid) VALUES(#{uid},#{sid});")
	int addFollow(Follow follow);
	/**
	 * ɾ��
	 * @param fid
	 * @return ���ر����ӵ����������������0���ʾʧ��
	 */
	@Delete("delete from follow  where uid = #{uid} and sid = #{sid}")
	int deleteFollow(Follow follow);
	
}
