package service.iService;

/**
 * @author lwy
 * ��ע����ӿ�
 */
public interface IFollowService {
	/**
	 * 
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
