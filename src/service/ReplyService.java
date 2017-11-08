package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dao.impl.ReplyDaoImpl;
import entity.Reply;
import service.iService.IReplyService;

public class ReplyService implements IReplyService {
	private ReplyDaoImpl rdi = new ReplyDaoImpl();
	private TopicService topicService = new TopicService();
	@Override
	public boolean deleteReplyOne(int rid) {
		
		return rdi.deleteReplyOne(rid)>0;
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
		if(!topicService.updateReplyCountAdd(rtid,ruid,rtime)){
			System.err.println("��������1ʧ��");
			return false;
		}else{
			return rdi.addReplyOne(reply) > 0;
		}
	}

	@Override
	public List<Reply> queryReplyListByRTID(int rtid) {
		return rdi.queryReplyListByRTID(rtid);
	}

}
