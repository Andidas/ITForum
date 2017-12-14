package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import service.iService.IPrivateLetterService;
import utils.db.MyBatisSessionFactory;
import dao.PrivateLetterDao;
import entity.PageMode;
import entity.PageParam;
import entity.PrivateLetter;

public class PrivateLetterService implements IPrivateLetterService {

	@Override
	public  boolean batchAdd(String puid,String ptouid,int type,String pcontent){
		if(puid.equals(ptouid))return false;
		List<PrivateLetter> letters = new ArrayList<PrivateLetter>();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(new Date());
		int uid = Integer.parseInt(puid);
		int touid = Integer.parseInt(ptouid);
		
		letters.add(new PrivateLetter(uid,touid,uid,touid,type,time,pcontent));
		letters.add(new PrivateLetter(touid,uid,uid,touid,type,time,pcontent));
		SqlSession sqlsession = MyBatisSessionFactory.getSession();
		try {
			sqlsession.getMapper(PrivateLetterDao.class).batchAdd(letters);
			sqlsession.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			sqlsession.rollback();
			return false;
		}finally{
			MyBatisSessionFactory.closeSession();
		}
	}
	@Override
	public boolean batchDelete(List<Integer> ids){
		SqlSession sqlsession = MyBatisSessionFactory.getSession();
		try {
			sqlsession.getMapper(PrivateLetterDao.class).batchDelete(ids);
			sqlsession.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			sqlsession.rollback();
			return false;
		}finally{
			MyBatisSessionFactory.closeSession();
		}
		
	}
	@Override
	public  List<PrivateLetter> findAll(){
		SqlSession session = MyBatisSessionFactory.getSession();
		List<PrivateLetter> plists = session.getMapper(PrivateLetterDao.class).findAll();
		MyBatisSessionFactory.closeSession();
		return plists;
	}
	


	@Override
	public PageMode<Map<String,Object>> queryMyPrivateLetterList(PageParam pageParam) {
		int start = (pageParam.getPageno() - 1) * pageParam.getPagesize();
		pageParam.setPageno(start);

		PageMode<Map<String,Object>> pm = new PageMode<Map<String,Object>>();
		List<Map<String,Object>> pageData = new ArrayList<Map<String,Object>>();

		SqlSession sqlSession = MyBatisSessionFactory.getSession();
		pageData = sqlSession.getMapper(PrivateLetterDao.class).queryMyPrivateLetterList(pageParam);

		pm.setData(pageData);
		pm.setPageParam(pageParam);
		pm.setTotalRecordCount(sqlSession.getMapper(PrivateLetterDao.class).queryMyPrivateLetterList_count(pageParam.getId()));

		MyBatisSessionFactory.closeSession();
		return pm;
	}
	
	@Override
	public PageMode<Map<String,Object>> queryMyPrivateLetterList_detail(PageParam pageParam) {
		int start = (pageParam.getPageno() - 1) * pageParam.getPagesize();
		pageParam.setPageno(start);

		PageMode<Map<String,Object>> pm = new PageMode<Map<String,Object>>();
		List<Map<String,Object>> pageData = new ArrayList<Map<String,Object>>();

		SqlSession sqlSession = MyBatisSessionFactory.getSession();
		pageData = sqlSession.getMapper(PrivateLetterDao.class).queryMyPrivateLetterList_detail(pageParam);

		pm.setData(pageData);
		pm.setPageParam(pageParam);
		pm.setTotalRecordCount(sqlSession.getMapper(PrivateLetterDao.class).queryMyPrivateLetterList_count(pageParam.getId()));

		MyBatisSessionFactory.closeSession();
		return pm;
	}
	@Override
	public boolean evenReaded(String user_id,String friend_id) {
		HashMap<String,Object> ids = new HashMap<String, Object>();
		ids.put("user_id",user_id);
		ids.put("friend_id",friend_id);
		SqlSession sqlSession = MyBatisSessionFactory.getSession();
		int result = sqlSession.getMapper(PrivateLetterDao.class).evenReaded(ids);
		sqlSession.commit();
		MyBatisSessionFactory.closeSession();
		return result>0;
	}
	
}