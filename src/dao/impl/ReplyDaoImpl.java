package dao.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import utils.DBUtils;
import dao.ReplyDao;
import db.DBAccess;
import entity.Reply;

/**
 * @author lwy
 *
 */
public class ReplyDaoImpl implements ReplyDao {
	SqlSession sqlSession = null;
	DBAccess dbAccess = new DBAccess();
	@Override
	public int deleteReplyOne(int rid) {
		int result = 0;
		try {
			sqlSession = dbAccess.getSqlSession();
			result= sqlSession.delete("Reply.deleteReplyOne",rid);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
			return result;
		}finally{
			if(sqlSession!=null)sqlSession.close();
		}
		return result;
	}

	@Override
	public int addReplyOne(Reply reply) {
		int result = 0;
		try {
			sqlSession = dbAccess.getSqlSession();
			result= sqlSession.insert("Reply.addReplyOne",reply);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
			return result;
		}finally{
			if(sqlSession!=null)sqlSession.close();
		}
		return result;
	}




}
