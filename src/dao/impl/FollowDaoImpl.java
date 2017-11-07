package dao.impl;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import dao.FollowDao;
import db.DBAccess;
import entity.Follow;

public class FollowDaoImpl implements FollowDao {
	 private SqlSession sqlSession = null;
	 private DBAccess dbAccess  = new DBAccess();
	@Override
	public int addFollow(Follow follow) {
		int result =0;
		try {
			sqlSession = dbAccess.getSqlSession();
			result = sqlSession.insert("Follow.addFollow",follow);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	@Override
	public int deleteFollow(int fid) {
		int result =0;
		try {
			sqlSession = dbAccess.getSqlSession();
			result = sqlSession.delete("Follow.deleteFollow",fid);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	@Override
	public int queryFollowID(Follow follow) {
		int result =0;
		try {
			sqlSession = dbAccess.getSqlSession();
			result = sqlSession.selectOne("Follow.queryFollowID",follow);
		} catch (IOException e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	@Override
	public int queryFollowCountBySid(int sid) {
		int result =0;
		try {
			sqlSession = dbAccess.getSqlSession();
			result = sqlSession.selectOne("Follow.queryFollowCountBySid",sid);
		} catch (IOException e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

}
