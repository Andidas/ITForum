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
	public boolean addFollow(String uname,String sname) {
		Follow follow = new Follow();
		int uid = udi.queryUserIDByName(uname);
		int sid = sdi.querySessionIDByName(sname);
		follow.setUid(uid);follow.setSid(sid);
		return fdi.addFollow(follow)>0;
	}

	@Override
	public boolean deleteFollow(String uname,String sname) {
		int uid = udi.queryUserIDByName(uname);
		int sid = sdi.querySessionIDByName(sname);
		Follow follow = new Follow();
		follow.setUid(uid);
		follow.setSid(sid);
		int fid = fdi.queryFollowID(follow);
		return fdi.deleteFollow(fid)>0;
	}

}
