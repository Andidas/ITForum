package service;

import java.util.List;

import service.iService.ITopicViewService;
import utils.ConstantsData;
import utils.ConstantsData.EnumDaoFactory;
import dao.ReplyDao;
import dao.TopicDao;
import dao.factory.DaoFactory;
import entity.PageMode;
import entity.PageParam;
import entity.Topic;
import entity.viewEntity.ReplyView;
import entity.viewEntity.TopicView;

public class TopicViewService implements ITopicViewService {
	private ReplyDao replyDao = DaoFactory.getInstance(EnumDaoFactory.REPLY).getReplyDao();
	private TopicDao topicDao = DaoFactory.getInstance(EnumDaoFactory.TOPIC).getTopicDao();

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
		 //该topic的所有回帖
		 PageMode<ReplyView> allReply = queryReplyViewPageMode(ConstantsData.PAGENO, ConstantsData.PAGESIZE, tid);
		 //和该topic相似的topics
		 List<Topic> sameList = topicDao.querySameTopicListByTSID(sessionid);
		 
		 topicView = topicDao.getTopicViewOne(tid);
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
