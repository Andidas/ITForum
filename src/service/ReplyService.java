package service;

import java.text.SimpleDateFormat;
import java.util.Date;

import service.iService.IReplyService;
import utils.sensitive_word.SensitivewordFilter;
import dao.ReplyDao;
import dao.impl.ReplyDaoImpl;
import dao.impl.TopicDaoImpl;
import entity.PageMode;
import entity.PageParam;
import entity.Reply;
import entity.Topic;

public class ReplyService implements IReplyService {
	private SensitivewordFilter filter = new SensitivewordFilter();
	private ReplyDao replyDao = new ReplyDaoImpl();
	@Override
	public PageMode<Reply> queryUserAllReply(int pageno,int pagesize,String uid){
		int id = Integer.parseInt(uid);
		PageParam param = new PageParam(pageno,pagesize,id);
		return replyDao.queryUserAllReply(param);
	}
	@Override
	public boolean deleteReplyOne(int rid) {
		return replyDao.deleteReplyOne(rid)>0;
	}
	
	@Override
	public boolean updateReplyCountAdd(int tid,int ruid,String rtime) {
		TopicDaoImpl tdi = new TopicDaoImpl();
		Topic topic = new Topic();
		topic.setTid(tid);
		topic.setTlastreplyuseid(ruid);
		topic.setTlastreplaytime(rtime);
		return tdi.updateReplyCountAdd(topic)>0;
	}
	@Override
	public boolean addReplyOne(String nowTopicTid,String nowSessionID,String nowUserID,String replyText) {
		String content = filter.replaceSensitiveWord(replyText, 1, "*");
		Reply reply = new Reply();
		int rtid= Integer.parseInt(nowTopicTid);
		int rsid= Integer.parseInt(nowSessionID);
		int ruid= Integer.parseInt(nowUserID);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String rtime = df.format(new Date());
		
		reply.setRtid(rtid);
		reply.setRsid(rsid);
		reply.setRuid(ruid);
		reply.setRtime(rtime);
		reply.setRcontent(content);
		if(!updateReplyCountAdd(rtid,ruid,rtime)){
			System.out.println("发帖数加1失败");
			return false;
		}else{
			return replyDao.addReplyOne(reply) > 0;
		}
	}


	

	

}
