package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dao.impl.ReplyDaoImpl;
import entity.PageMode;
import entity.PageParam;
import entity.Reply;
import entity.ReplyView;
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
		String rtime = df.format(new Date());//获取注册时间
		
		reply.setRtid(rtid);
		reply.setRsid(rsid);
		reply.setRuid(ruid);
		reply.setRtime(rtime);
		reply.setRcontent(replyText);
		if(!topicService.updateReplyCountAdd(rtid,ruid,rtime)){
			System.out.println("回帖数加1失败");
			return false;
		}else{
			return rdi.addReplyOne(reply) > 0;
		}
	}

	

	@Override
	public PageMode<ReplyView> queryReplyViewPageMode(int pageno, int pagesize,int tsid) {
		PageParam pageParam = new PageParam(pageno, pagesize, tsid);
		return rdi.queryReplyViewListByRTID(pageParam);
	}

}
