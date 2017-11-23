package service.iService;

/**
 * @author lwy
 * ��ע����ӿ�
 */
public interface IFollowService {
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
