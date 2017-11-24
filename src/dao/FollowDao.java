package dao;

import java.util.List;

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
	List<FollowView>queryFollowList(int uid);
	/**
	 * �Ƿ񱻸��û���ע
	 * @param follow
	 * @return
	 */
	int isBeFollow(Follow follow);
	/**
	 * ��ѯsession�Ĺ�ע����
	 * @param sid
	 * @return
	 */
	int queryFollowCount(int sid);
	/**
	 * ���follow
	 * @param follow
	 * @return ���ر����ӵ����������������0���ʾʧ��
	 */
	int addFollow(Follow follow);
	/**
	 * ɾ��
	 * @param fid
	 * @return ���ر����ӵ����������������0���ʾʧ��
	 */
	int deleteFollow(int fid);
	/**
	 * ͨ�� uid ��sid ��ѯfid
	 * @param follow
	 * @return fid 
	 */
	public abstract int queryFollowID(Follow follow);
}
