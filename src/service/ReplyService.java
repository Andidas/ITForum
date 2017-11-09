package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dao.impl.ReplyDaoImpl;
import dao.impl.TopicDaoImpl;
import entity.PageMode;
import entity.PageParam;
import entity.Reply;
import entity.ReplyView;
import entity.Topic;
import service.iService.IReplyService;

public class ReplyService implements IReplyService {
	private ReplyDaoImpl rdi = new ReplyDaoImpl();

	@Override
	public boolean deleteReplyOne(int rid) {
		return rdi.deleteReplyOne(rid)>0;
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
		
		Reply reply = new Reply();
		int rtid= Integer.parseInt(nowTopicTid);
		int rsid= Integer.parseInt(nowSessionID);
		int ruid= Integer.parseInt(nowUserID);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String rtime = df.format(new Date());//��ȡע��ʱ��
		
		reply.setRtid(rtid);
		reply.setRsid(rsid);
		reply.setRuid(ruid);
		reply.setRtime(rtime);
		reply.setRcontent(replyText);
		if(!updateReplyCountAdd(rtid,ruid,rtime)){
			System.out.println("��������1ʧ��");
			return false;
		}else{
			return rdi.addReplyOne(reply) > 0;
		}
	}

	

	

}
