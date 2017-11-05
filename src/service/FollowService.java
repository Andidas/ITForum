package service;

import dao.impl.FollowDaoImpl;
import entity.Follow;
import service.iService.IFollowService;

public class FollowService implements IFollowService {
	FollowDaoImpl fdi = new FollowDaoImpl();
	@Override
	public void addFollow(int uid,int sid) {
		Follow follow = new Follow();
		follow.setUid(uid);follow.setSid(sid);
		fdi.addFollow(follow);
	}

	@Override
	public void deleteFollow(int fid) {
		fdi.deleteFollow(fid);
	}

}
