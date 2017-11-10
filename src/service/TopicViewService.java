package service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.impl.ReplyDaoImpl;
import dao.impl.TopicDaoImpl;
import service.iService.ITopicViewService;
import entity.PageMode;
import entity.PageParam;
import entity.ReplyView;
import entity.Topic;
import entity.TopicView;

public class TopicViewService implements ITopicViewService {
	private ReplyDaoImpl rdi = new ReplyDaoImpl();
	private TopicDaoImpl tdi = new TopicDaoImpl();
	@Override
	public String neatenSessionContent(String uname, String ttopic,
			String tcontents) {

		String newContents = "<li><div class='col-xs-2'><div class='thumbsUp'>"
				+"<p title='�ظ�����'><span class='activeSpan'>0</span><span class='glyphicon glyphicon-comment'>"
				+"</span></p><p title='�ۿ�����'><span class='activeSpan'>0</span>"
				+"<span class='glyphicon glyphicon glyphicon glyphicon-eye-open'></span></p></div></div>"
				+"<div class='panel col-xs-10'><div class='panel-heading'><a href='javaScript:void(0)'class='TopicTName' title='��Ŀ'>"
				+ ttopic
				+ "</a></div><div class='panel-body' title='����'>"
				+  neatenSessionContentInit(tcontents)
				+ "</div><div class='panel-footer clearfix'><div style='float: right'><span class='glyphicon glyphicon-user'></span><a href='user.jsp' title='����' target='_blank'>"
				+ uname
				+ "</a></div></div></div></li>";
				
		
		return newContents;
	}
	/**
	 * ��������<p></p>��������ݣ���ͼƬ��������
	 */
	@Override
	public String neatenSessionContentInit(String tcontents){
		List<String> imgSrcs = getImageAndContent(tcontents);
		/*��������<p></p>��������ݣ���ͼƬ��������*/
		
		StringBuilder newContentsInit =new StringBuilder("<div>");
		newContentsInit.append(tcontents.replaceAll("style=", "styleOld=").replaceAll("<img ", "<img style='display:none;' ").replaceAll("<p>", "").replaceAll("</p>","").replaceAll("<br>",""));
		newContentsInit.append("</div>");
		/*��ͼƬ���ں���*/
		for(int i=0,j=0;i<imgSrcs.size()&j<3;i++,j++){
			newContentsInit.append("<img "+imgSrcs.get(i)+" width='137px' height='137' >");
		}
		
		return newContentsInit.toString();
	}
	/*���ͼ���src*/
	private List<String> getImageAndContent(String tcontents){
		 List<String> imgSrc = new ArrayList<String>();//ͼ���src
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
		return tdi.splitPage(pageParam);
	}
	@Override
	public TopicView getTopicViewOne(String id,String sid) {
		int tid = Integer.parseInt(id);
    	 TopicView topicView = null;
		 int sessionid = Integer.parseInt(sid);
		 Topic topic = tdi.queryTopicOneByTopic(tid);
		 //��topic�����л���
		 PageMode<ReplyView> allReply = queryReplyViewPageMode(1, 5, topic.getTid());
		 //�͸�topic���Ƶ�topics
		 List<Topic> sameList = tdi.querySameTopicListByTSID(sessionid);
		 
		 topicView = tdi.getTopicViewOne(tid);
		 topicView.setAllReply(allReply);	
		 topicView.setSameTopic(sameList);
		return topicView;
	}
	@Override
	public PageMode<ReplyView> queryReplyViewPageMode(int pageno, int pagesize,int rtid) {
		PageParam pageParam = new PageParam(pageno, pagesize, rtid);
		return rdi.queryReplyViewListByRTID(pageParam);
	}
	

}
