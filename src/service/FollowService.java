package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import service.iService.IFollowService;
import utils.db.MyBatisSessionFactory;
import dao.FollowDao;
import entity.Follow;
import entity.viewEntity.FollowView;

public class FollowService implements IFollowService {
	@Override
	public boolean addFollow(String userid, String sessionid) {
		SqlSession session = MyBatisSessionFactory.getSession();
		Follow follow = new Follow();
		int uid = Integer.parseInt(userid);
		int sid = Integer.parseInt(sessionid);
		follow.setUid(uid);
		follow.setSid(sid);
		int result = session.getMapper(FollowDao.class).addFollow(follow);
		session.commit();
		MyBatisSessionFactory.closeSession();
		return result > 0;
	}

	@Override
	public boolean deleteFollow(String userid,String sessionid) {
		SqlSession session = MyBatisSessionFactory.getSession();
		int uid = Integer.parseInt(userid);
		int sid = Integer.parseInt(sessionid);
		Follow follow = new Follow();
		follow.setUid(uid);
		follow.setSid(sid);
		int fid = session.getMapper(FollowDao.class).deleteFollow(follow);
		session.commit();
		MyBatisSessionFactory.closeSession();
		return fid>0;
	}

	@Override
	public int queryFollowCount(int sid) {
		SqlSession session = MyBatisSessionFactory.getSession();
		int result = session.getMapper(FollowDao.class).queryFollowCount(sid);
		MyBatisSessionFactory.closeSession();
		return result;
	}

	@Override
	public boolean isBeFollow(String uid, String sid) {
		SqlSession session = MyBatisSessionFactory.getSession();
		int uuid = Integer.parseInt(uid);
		int ssid = Integer.parseInt(sid);
		Follow follow = new Follow(uuid,ssid);
		int result = session.getMapper(FollowDao.class).isBeFollow(follow);
		MyBatisSessionFactory.closeSession();
		return result>0;
	}

	@Override
	public List<FollowView> queryFollowList(String uid) {
		SqlSession session = MyBatisSessionFactory.getSession();
		int id = Integer.parseInt(uid);
		List<FollowView> lists = session.getMapper(FollowDao.class).queryFollowList(id);
		MyBatisSessionFactory.closeSession();
		return lists;
	}

}
