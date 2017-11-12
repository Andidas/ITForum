package service;

import dao.impl.FollowDaoImpl;
import dao.impl.SessionDaoImpl;
import dao.impl.UserDaoImpl;
import entity.Follow;
import service.iService.IFollowService;

public class FollowService implements IFollowService {
	FollowDaoImpl fdi = new FollowDaoImpl();
	UserDaoImpl udi = new UserDaoImpl();
	SessionDaoImpl sdi = new SessionDaoImpl();
	@Override
	public boolean addFollow(String userid, String sessionid) {
		Follow follow = new Follow();
		int uid = Integer.parseInt(userid);
		int sid = Integer.parseInt(sessionid);
		follow.setUid(uid);
		follow.setSid(sid);
		return fdi.addFollow(follow) > 0;
	}

	@Override
	public boolean deleteFollow(String userid,String sessionid) {
		int uid = Integer.parseInt(userid);
		int sid = Integer.parseInt(sessionid);
		Follow follow = new Follow();
		follow.setUid(uid);
		follow.setSid(sid);
		int fid = fdi.queryFollowID(follow);
		if(fid>0){
			return fdi.deleteFollow(fid)>0;			
		}else{
			return false;
		}
	}

	@Override
	public int queryFollowCount(int sid) {
		return fdi.queryFollowCount(sid);
	}

}
