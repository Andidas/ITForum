package service.iService;

import java.util.List;

import entity.viewEntity.FollowView;

/**
 * @author lwy
 * ��ע����ӿ�
 */
public interface IFollowService {
	/**
	 * �����û���ע��session
	 * @param uid �û�id
	 * @return
	 */
	List<FollowView>queryFollowList(String uid);
	/**
	 * session�Ƿ�user��ע
	 * @param uid
	 * @param sid
	 * @return
	 */
	boolean isBeFollow(String uid,String sid);
	/**
	 * ��ѯ���Ĺ�ע����
	 * @param sid
	 * @return
	 */
	int queryFollowCount(int sid);
	/**
	 * @param uname
	 * @param sname
	 * @return ��ע�ɹ�Ϊtrue
	 */
	boolean addFollow(String uname,String sname);
	/**
	 * @param uname
	 * @param sname
	 * @return ȡ����ע�ɹ�Ϊtrue
	 */
	boolean deleteFollow(String uname,String sname);
}
