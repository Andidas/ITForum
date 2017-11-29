package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import utils.db.MyBatisSessionFactory;
import dao.PrivateLetterDao;
import entity.PrivateLetter;

public class PrivateLetterService {

	public boolean insertOne(String puid,String ptouid,String pcontent){
		SqlSession session = MyBatisSessionFactory.getSession();
		if(puid.equals(ptouid))return false;
		int uid = Integer.parseInt(puid);
		int touid = Integer.parseInt(ptouid);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ttime = df.format(new Date());
		PrivateLetter pletter = new PrivateLetter(uid,touid,ttime,pcontent);
		
		int result = session.getMapper(PrivateLetterDao.class).insertOne(pletter);
		session.commit();
		MyBatisSessionFactory.closeSession();
		return result>0;
	}
	
	public  List<PrivateLetter> findAll(){
		SqlSession session = MyBatisSessionFactory.getSession();
		List<PrivateLetter> plists = session.getMapper(PrivateLetterDao.class).findAll();
		MyBatisSessionFactory.closeSession();
		return plists;
	}
	public List<PrivateLetter> queryDialogList(String puid,String ptouid){
		SqlSession session = MyBatisSessionFactory.getSession();
		int uid = Integer.parseInt(puid);
		int touid = Integer.parseInt(ptouid);
		PrivateLetter pletter = new PrivateLetter();
		pletter.setPuid(uid);
		pletter.setPtouid(touid);
		List<PrivateLetter> plists = session.getMapper(PrivateLetterDao.class).queryDialogList(pletter);
		MyBatisSessionFactory.closeSession();
		return plists;
	}
}
