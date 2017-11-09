package dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.ReplyDao;
import db.DBAccess;
import entity.PageMode;
import entity.PageParam;
import entity.Reply;
import entity.ReplyView;
import entity.Topic;

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

	

	@Override
	public PageMode<ReplyView> queryReplyViewListByRTID(PageParam pageParam) {
		int start = (pageParam.getPageno()-1)*pageParam.getPagesize();
		pageParam.setPageno(start);
		try {
			PageMode<ReplyView> pm = new PageMode<ReplyView>();
			List<ReplyView> pageData = new ArrayList<ReplyView>();
			
			sqlSession = dbAccess.getSqlSession();
			pageData= sqlSession.selectList("Reply.queryReplyViewListByRTID",pageParam);
			pm.setData(pageData);
			pm.setPageParam(pageParam);
			pm.setTotalRecordCount(this.rowCount(pageParam.getId()));
			return pm;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null)sqlSession.close();
		}
		return null;
	}

	public int rowCount(int id) {
		try {
			int num = 0;
			sqlSession = dbAccess.getSqlSession();
			num = sqlSession.selectOne("Reply.ReplyrowNum", id);
			return num;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}



}
