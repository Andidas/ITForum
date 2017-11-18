package service;

import dao.FollowDao;
import dao.factory.DaoFactory;
import entity.Follow;
import service.iService.IFollowService;
import utils.ConstantsData.EnumDaoFactory;

public class FollowService implements IFollowService {
	private FollowDao followDao = DaoFactory.getInstance(EnumDaoFactory.FOLLOW).getFollowDao();
	@Override
	public boolean addFollow(String userid, String sessionid) {
		Follow follow = new Follow();
		int uid = Integer.parseInt(userid);
		int sid = Integer.parseInt(sessionid);
		follow.setUid(uid);
		follow.setSid(sid);
		return followDao.addFollow(follow) > 0;
	}

	@Override
	public boolean deleteFollow(String userid,String sessionid) {
		int uid = Integer.parseInt(userid);
		int sid = Integer.parseInt(sessionid);
		Follow follow = new Follow();
		follow.setUid(uid);
		follow.setSid(sid);
		int fid = followDao.queryFollowID(follow);
		if(fid>0){
			return followDao.deleteFollow(fid)>0;			
		}else{
			return false;
		}
	}

	@Override
	public int queryFollowCount(int sid) {
		return followDao.queryFollowCount(sid);
	}

}
