package dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import utils.db.DBAccess;
import dao.PrivateLetterDao;
import entity.PrivateLetter;

public class PrivateLetterImpl implements PrivateLetterDao {
	
	 private SqlSession sqlSession = null;
	 private DBAccess dbAccess  = new DBAccess();
	@Override
	public List<PrivateLetter> findAll() {
		try {
			sqlSession = dbAccess.getSqlSession();
			List<PrivateLetter> list = sqlSession.selectList("PrivateLetter.queryAll");
			return list;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return null;
	}
	@Override
	public int insertOne(PrivateLetter pletter) {
		try {
			sqlSession = dbAccess.getSqlSession();
			int result = sqlSession.insert("PrivateLetter.insertOne",pletter);
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
	public List<PrivateLetter> queryDialogList(PrivateLetter pletter) {
		try {
			sqlSession = dbAccess.getSqlSession();
			List<PrivateLetter> list = sqlSession.selectList("PrivateLetter.queryDialogList",pletter);
			return list;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return null;
	}
	
}
