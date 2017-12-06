package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import service.iService.ISensitiveWordService;
import utils.db.MyBatisSessionFactory;
import dao.PrivateLetterDao;
import dao.SensitiveWordDao;
import entity.PageMode;
import entity.PageParam;
import entity.SensitiveWord;

public class SensitiveWordService implements ISensitiveWordService {

	@Override
	public Set<String> findAll() {
		SqlSession session = MyBatisSessionFactory.getSession();
		Set<String> words = session.getMapper(SensitiveWordDao.class).findAll();
		MyBatisSessionFactory.closeSession();
		return words;
	}

	@Override
	public boolean batchAdd(List<String> words) {
		SqlSession sqlsession = MyBatisSessionFactory.getSession();
		try {
			sqlsession.getMapper(SensitiveWordDao.class).batchAdd(words);
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
	public boolean batchDelete(List<Integer> ids) {
		SqlSession sqlsession = MyBatisSessionFactory.getSession();
		try{
			sqlsession.getMapper(SensitiveWordDao.class).batchDelete(ids);
			sqlsession.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			sqlsession.rollback();
			return false;
		}finally{
			MyBatisSessionFactory.closeSession();
		}
	}

	@Override
	public PageMode<SensitiveWord> querySensitiveWords(PageParam pageParam) {
		int start = (pageParam.getPageno() - 1) * pageParam.getPagesize();
		pageParam.setPageno(start);

		PageMode<SensitiveWord> pm = new PageMode<SensitiveWord>();
		List<SensitiveWord> pageData = new ArrayList<SensitiveWord>();

		SqlSession sqlSession = MyBatisSessionFactory.getSession();
		pageData = sqlSession.getMapper(SensitiveWordDao.class).querySensitiveWords(pageParam);

		pm.setData(pageData);
		pm.setPageParam(pageParam);
		pm.setTotalRecordCount(sqlSession.getMapper(PrivateLetterDao.class).queryMyPrivateLetterList_count(pageParam.getId()));

		MyBatisSessionFactory.closeSession();
		return pm;
	}

}
