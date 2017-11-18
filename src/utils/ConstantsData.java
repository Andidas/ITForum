package utils;

/**
 * ��������
 * @author lwy
 *
 */
public class ConstantsData {
	/**
	 * ÿһҳ��ʾ��������
	 */
	public final static int PAGESIZE = 5;
	/**
	 * ��ǰ�ڵڼ�ҳ
	 */
	public final static int PAGENO = 1;
	/**
	 * dao�Ĺ���ö��
	 * @author lwy
	 * @param FOLLOW -> FollowDao�ӿ�ʵ��
	 * @param REPLY -> ReplyDao
	 * @param SESSION -> SessionDao
	 * @param TOPIC -> TopicDao
	 * @param USER -> UserDao
	 */
	public enum EnumDaoFactory {
		FOLLOW, REPLY, SESSION, TOPIC, USER;
	}
}
