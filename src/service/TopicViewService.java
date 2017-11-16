package service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import service.iService.ITopicViewService;
import dao.ReplyDao;
import dao.TopicDao;
import dao.factory.DaoFactory;
import dao.factory.DaoFactory.EnumDaoFactory;
import entity.PageMode;
import entity.PageParam;
import entity.Topic;
import entity.viewEntity.ReplyView;
import entity.viewEntity.TopicView;

public class TopicViewService implements ITopicViewService {
	private ReplyDao replyDao = DaoFactory.getInstance(EnumDaoFactory.REPLY).getReplyDao();
	private TopicDao topicDao = DaoFactory.getInstance(EnumDaoFactory.TOPIC).getTopicDao();
	private final static int PAGENO = 1;//�ڼ�ҳ
	private final static int PAGESIZE =5;//ÿҳ����
	
	@Override
	public String neatenSessionContentInit(String tcontents){
		List<String> imgSrcs = getImageAndContent(tcontents);
		//��������<p></p>��������ݣ���ͼƬ��������
		StringBuilder newContentsInit =new StringBuilder("<div>");
		newContentsInit.append(tcontents.replaceAll("style=", "styleOld=").replaceAll("<img ", "<img style='display:none;' ").replaceAll("<p>", "").replaceAll("</p>","").replaceAll("<br>",""));
		newContentsInit.append("</div>");
		/*��ͼƬ���ں���*/
		for(int i=0,j=0;i<imgSrcs.size()&j<3;i++,j++){
			newContentsInit.append("<img "+imgSrcs.get(i)+" width='137px' height='137' >");
		}
		
		return newContentsInit.toString();
	}
	
	@Override
	public List<String> getImageAndContent(String tcontents){
		 List<String> imgSrc = new ArrayList<String>();
		 String regex = "src=\"\\S*\"";//ͼ�������
		 Pattern p = Pattern.compile(regex);
	     Matcher m = p.matcher(tcontents); // ��ȡ matcher ����
	     while(m.find()) {
	    	 imgSrc.add(tcontents.substring(m.start(),m.end()+1));
	       }
		return imgSrc;
	}
	@Override
	public PageMode<TopicView> TopicSplitPage(int pageno, int pagesize,int tsid) {
		PageParam pageParam = new PageParam(pageno, pagesize, tsid);
		return topicDao.splitPage(pageParam);
	}
	@Override
	public TopicView getTopicViewOne(String id,String sid) {
		int tid = Integer.parseInt(id);
    	 TopicView topicView = null;
		 int sessionid = Integer.parseInt(sid);
		 //��topic�����л���
		 PageMode<ReplyView> allReply = queryReplyViewPageMode(PAGENO, PAGESIZE, tid);
		 //�͸�topic���Ƶ�topics
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
