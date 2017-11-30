package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.ReplyDao;
import utils.db.MyBatisSessionFactory;
import entity.PageMode;
import entity.PageParam;
import entity.Reply;
import entity.viewEntity.ReplyView;

/**
 * @author lwy
 *
 */
public class ReplyDaoImpl implements ReplyDao {

	@Override
	public int deleteReplyOne(int rid) {
		int result = 0;
		SqlSession sqlSession = MyBatisSessionFactory.getSession();
		result = sqlSession.delete("Reply.deleteReplyOne", rid);
		sqlSession.commit();
		MyBatisSessionFactory.closeSession();
		return result;
	}

	@Override
	public int addReplyOne(Reply reply) {
		int result = 0;

		SqlSession sqlSession = MyBatisSessionFactory.getSession();
		result = sqlSession.insert("Reply.addReplyOne", reply);
		sqlSession.commit();

		MyBatisSessionFactory.closeSession();

		return result;
	}

	@Override
	public PageMode<ReplyView> queryReplyViewList(PageParam pageParam) {
		int start = (pageParam.getPageno() - 1) * pageParam.getPagesize();
		pageParam.setPageno(start);

		PageMode<ReplyView> pm = new PageMode<ReplyView>();
		List<ReplyView> pageData = new ArrayList<ReplyView>();

		SqlSession sqlSession = MyBatisSessionFactory.getSession();
		pageData = sqlSession.selectList("Reply.queryReplyViewList", pageParam);

		pm.setData(pageData);
		pm.setPageParam(pageParam);
		pm.setTotalRecordCount(this.ReplyrowNum(pageParam.getId()));

		MyBatisSessionFactory.closeSession();
		return pm;

	}

	@Override
	public int ReplyrowNum(int id) {
		int num = 0;
		SqlSession sqlSession = MyBatisSessionFactory.getSession();
		num = sqlSession.selectOne("Reply.ReplyrowNum", id);
		return num;

	}

	@Override
	public PageMode<Reply> queryUserAllReply(PageParam pageParam) {
		int start = (pageParam.getPageno() - 1) * pageParam.getPagesize();
		pageParam.setPageno(start);
		PageMode<Reply> pm = new PageMode<Reply>();
		List<Reply> pageData = new ArrayList<Reply>();

		SqlSession sqlSession = MyBatisSessionFactory.getSession();
		pageData = sqlSession.selectList("Reply.queryUserAllReply", pageParam);

		pm.setData(pageData);
		pm.setPageParam(pageParam);
		pm.setTotalRecordCount(this.UserReplyrowNum(pageParam.getId()));
		return pm;

	}

	private int UserReplyrowNum(int id) {
		int num = 0;
		SqlSession sqlSession = MyBatisSessionFactory.getSession();
		num = sqlSession.selectOne("Reply.UserReplyrowNum", id);
		return num;

	}

}
