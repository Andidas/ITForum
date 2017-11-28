package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import utils.ConstantsData.EnumDaoFactory;
import dao.PrivateLetterDao;
import dao.factory.DaoFactory;
import entity.PrivateLetter;

public class PrivateLetterService {
	PrivateLetterDao pld = DaoFactory.getInstance(EnumDaoFactory.PRIVATELETTER).getPrivateLetterDao();
	
	public boolean insertOne(String puid,String ptouid,String pcontent){
		if(puid.equals(ptouid))return false;
		int uid = Integer.parseInt(puid);
		int touid = Integer.parseInt(ptouid);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ttime = df.format(new Date());
		
		PrivateLetter pletter = new PrivateLetter(uid,touid,ttime,pcontent);
		
		return pld.insertOne(pletter)>0;
	}
	
	public  List<PrivateLetter> findAll(){
		return pld.findAll();
	}
	public List<PrivateLetter> queryDialogList(String puid,String ptouid){
		int uid = Integer.parseInt(puid);
		int touid = Integer.parseInt(ptouid);
		PrivateLetter pletter = new PrivateLetter();
		pletter.setPuid(uid);
		pletter.setPtouid(touid);
		
		return pld.queryDialogList(pletter);
	}
}
