package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import service.iService.ILzlReplyService;
import utils.db.MyBatisSessionFactory;
import dao.LzlReplyDao;
import entity.LzlReply;

public class LzlReplyService implements ILzlReplyService {

	@Override
	public boolean deleteLzlReply(String lid) {
		int id = Integer.parseInt(lid);
		SqlSession session = MyBatisSessionFactory.getSession();
		int result = session.getMapper(LzlReplyDao.class).deleteLzlReply(id);
		session.commit();
		MyBatisSessionFactory.closeSession();
		return result>0;
	}

	@Override
	public List<LzlReply> queryAllLzlReply() {
		SqlSession session = MyBatisSessionFactory.getSession();
		List<LzlReply> lzlReplys = session.getMapper(LzlReplyDao.class).queryAllLzlReply();
		return lzlReplys;
	}

	@Override
	public LzlReply insertLzlReply(String rid,String uid,String content) {
		int lrid = Integer.parseInt(rid);
		int luid = Integer.parseInt(uid);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ttime = df.format(new Date());
		LzlReply lzlReply = new LzlReply(lrid,luid,content,ttime);
		
		SqlSession session = MyBatisSessionFactory.getSession();
		session.getMapper(LzlReplyDao.class).insertLzlReply(lzlReply);
		session.commit();
		MyBatisSessionFactory.closeSession();
		return lzlReply;
	}

	@Override
	public List<Map<String, Object>> queryLzlReplyByLrid(String rid) {
		int lrid = Integer.parseInt(rid);
		HashMap<String,Object> param = new HashMap<String,Object>();
		param.put("type", "lrid");
		param.put("id", lrid);
		SqlSession session = MyBatisSessionFactory.getSession();
		List<Map<String, Object>> lzlReplys = session.getMapper(LzlReplyDao.class).queryLzlReplyByLrid(param);
		return lzlReplys;
	}
	
	@Override
	public List<Map<String, Object>> queryLzlReplyByLid(String id) {
		int lid = Integer.parseInt(id);
		HashMap<String,Object> param = new HashMap<String,Object>();
		param.put("type", "lid");
		param.put("id", lid);
		SqlSession session = MyBatisSessionFactory.getSession();
		List<Map<String, Object>> lzlReplys = session.getMapper(LzlReplyDao.class).queryLzlReplyByLrid(param);
		return lzlReplys;
	}

}
