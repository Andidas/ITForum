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
		try {
			int result =0;
			sqlSession = dbAccess.getSqlSession();
			result = sqlSession.insert("Follow.addFollow",follow);
			sqlSession.commit();
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return 0;
	}

	@Override
	public int deleteFollow(int fid) {
		try {
			int result =0;
			sqlSession = dbAccess.getSqlSession();
			result = sqlSession.delete("Follow.deleteFollow",fid);
			sqlSession.commit();
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return 0;
	}

	@Override
	public int queryFollowID(Follow follow) {
		try {
			int result =0;
			sqlSession = dbAccess.getSqlSession();
			result = sqlSession.selectOne("Follow.queryFollowID",follow);
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return 0;
	}

	@Override
	public int queryFollowCount(int sid) {
		int result =0;
		try {
			sqlSession = dbAccess.getSqlSession();
			result = sqlSession.selectOne("Follow.queryFollowCountBySid",sid);
		} catch (IOException e) {
			e.printStackTrace();
			return result;
		}finally{
			sqlSession.close();
		}
		return result;
	}

}
