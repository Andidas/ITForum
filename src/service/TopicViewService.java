package service;

import java.util.List;

import service.iService.ITopicViewService;
import utils.ConstantsData;
import utils.TransformTime;
import dao.ReplyDao;
import dao.TopicDao;
import dao.impl.ReplyDaoImpl;
import dao.impl.TopicDaoImpl;
import entity.PageMode;
import entity.PageParam;
import entity.Topic;
import entity.viewEntity.ReplyView;
import entity.viewEntity.TopicView;

public class TopicViewService implements ITopicViewService {
	private ReplyDao replyDao = new ReplyDaoImpl();;
	private TopicDao topicDao =new TopicDaoImpl();
	@Override
	public PageMode<TopicView> TopicSplitPage(int pageno, int pagesize,int tsid) {
		PageParam pageParam = new PageParam(pageno, pagesize, tsid);
		return topicDao.splitPage(pageParam);
	}
	@Override
	public PageMode<TopicView> TopicSplitPage(int pageno, int pagesize) {
		PageParam pageParam = new PageParam(pageno, pagesize);
		return topicDao.splitPage(pageParam);
	}
	@Override
	public TopicView getTopicViewOne(String id,String sid) {
		int tid = Integer.parseInt(id);
    	 TopicView topicView = null;
		 int sessionid = Integer.parseInt(sid);

		 PageMode<ReplyView> allReply = queryReplyViewPageMode(ConstantsData.PAGENO, ConstantsData.PAGESIZE, tid);
		 List<Topic> sameList = topicDao.querySameTopicListByTSID(sessionid);
		 
		 topicView = topicDao.getTopicViewOne(tid);
		 String oldtime = topicView.getTtime();
		 topicView.setTtime(TransformTime.howLongFromNow(oldtime));
		 topicView.setTlastreplaytime(TransformTime.howLongFromNow(topicView.getTlastreplaytime()));
		 topicView.setAllReply(allReply);	
		 topicView.setSameTopic(sameList);
		return topicView;
	}
	@Override
	public PageMode<ReplyView> queryReplyViewPageMode(int pageno, int pagesize,int rtid) {
		PageParam pageParam = new PageParam(pageno, pagesize, rtid);
		return replyDao.queryReplyViewList(pageParam);
	}
	

}
