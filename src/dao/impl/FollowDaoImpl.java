package dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import utils.db.DBAccess;
import dao.FollowDao;
import entity.Follow;
import entity.viewEntity.FollowView;

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
		try {
			int result =0;
			sqlSession = dbAccess.getSqlSession();
			result = sqlSession.selectOne("Follow.queryFollowCountBySid",sid);
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return 0;
	}

	@Override
	public int isBeFollow(Follow follow) {
		try {
			int result =0;
			sqlSession = dbAccess.getSqlSession();
			result = sqlSession.selectOne("Follow.isBeFollow",follow);
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return 0;
		
	}

	@Override
	public List<FollowView> queryFollowList(int uid) {
		try {
			List<FollowView> followView = null;
			sqlSession = dbAccess.getSqlSession();
			followView = sqlSession.selectList("Follow.queryFollowList",uid);
			return followView;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
