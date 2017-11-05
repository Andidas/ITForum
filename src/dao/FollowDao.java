package dao;

import entity.Follow;

public interface FollowDao {
	int addFollow(Follow follow);
	int deleteFollow(int fid);
	
}
