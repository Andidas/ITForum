package utils;

/**
 * 常量数据
 * @author lwy
 *
 */
public class ConstantsData {
	/**
	 * 每一页显示几条数据
	 */
	public final static int PAGESIZE = 5;
	public final static int PAGESIZE_20 = 20;
	public final static int PAGESIZE_10 = 10;
	/**
	 * 当前在第几页
	 */
	public final static int PAGENO = 1;
	/**
	 * dao的工厂枚举
	 * @author lwy
	 * @param FOLLOW -> FollowDao接口实例
	 * @param REPLY -> ReplyDao
	 * @param SESSION -> SessionDao
	 * @param TOPIC -> TopicDao
	 * @param USER -> UserDao
	 */
	public enum EnumDaoFactory {
		FOLLOW, REPLY, SESSION, TOPIC, USER;
	}
}
