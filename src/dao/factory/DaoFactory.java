package dao.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import utils.ConstantsData.EnumDaoFactory;
import dao.FollowDao;
import dao.PrivateLetterDao;
import dao.ReplyDao;
import dao.SessionDao;
import dao.TopicDao;
import dao.UserDao;

public class DaoFactory {

	private DaoFactory(EnumDaoFactory enumFactory) {
		InputStream inStream = DaoFactory.class.getClassLoader()
				.getResourceAsStream("dao/factory/daoconfig.properties");
		Properties prop = new Properties();
		try {
			prop.load(inStream);
			setDaoInstance(prop, enumFactory);
		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);// 此问题非常严重
		} finally {
			try {
				if (inStream != null)
					inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 为接口实例赋值，用到反射机制
	 * @param prop
	 * @param enumFactory
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	private void setDaoInstance(Properties prop, EnumDaoFactory enumFactory)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {

		switch (enumFactory) {
		case FOLLOW:
			String followDaoClzz = prop.getProperty("FollowDaoFactory");
			followDao = (FollowDao) Class.forName(followDaoClzz).newInstance();
			break;
		case REPLY:
			String replyDaoClzz = prop.getProperty("ReplyDaoFactory");
			replyDao = (ReplyDao) Class.forName(replyDaoClzz).newInstance();
			break;
		case SESSION:
			String sessionDaoClzz = prop.getProperty("SessionDaoFactory");
			sessionDao = (SessionDao) Class.forName(sessionDaoClzz)
					.newInstance();
			break;
		case TOPIC:
			String topicDaoClzz = prop.getProperty("TopicDaoFactory");
			topicDao = (TopicDao) Class.forName(topicDaoClzz).newInstance();
			break;
		case USER:
			String userDaoClzz = prop.getProperty("UserDaoFactory");
			userDao = (UserDao) Class.forName(userDaoClzz).newInstance();
			break;
		case PRIVATELETTER:
			String PrivateLetterDaoClzz = prop.getProperty("PrivateLetterDaoFactory");
			privateLetterDao = (PrivateLetterDao) Class.forName(PrivateLetterDaoClzz).newInstance();
			break;
		default:
			break;
		}

	}

	/**
	 * 实例DaoFactory
	 * @param enumFactory 枚举
	 * @return
	 */
	public static DaoFactory getInstance(EnumDaoFactory enumFactory) {
		return new DaoFactory(enumFactory);
	}

	public FollowDao getFollowDao() {
		return followDao;
	}

	public ReplyDao getReplyDao() {
		return replyDao;
	}

	public TopicDao getTopicDao() {
		return topicDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public SessionDao getSessionDao() {
		return sessionDao;
	}
	public  PrivateLetterDao getPrivateLetterDao() {
		return privateLetterDao;
	}
	
	private static FollowDao followDao = null;
	private static ReplyDao replyDao = null;
	private static TopicDao topicDao = null;
	private static UserDao userDao = null;
	private static SessionDao sessionDao = null;
	private static PrivateLetterDao privateLetterDao = null;

	
}
