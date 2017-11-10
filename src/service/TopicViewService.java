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
				+"<p title='回复条数'><span class='activeSpan'>0</span><span class='glyphicon glyphicon-comment'>"
				+"</span></p><p title='观看人数'><span class='activeSpan'>0</span>"
				+"<span class='glyphicon glyphicon glyphicon glyphicon-eye-open'></span></p></div></div>"
				+"<div class='panel col-xs-10'><div class='panel-heading'><a href='javaScript:void(0)'class='TopicTName' title='题目'>"
				+ ttopic
				+ "</a></div><div class='panel-body' title='内容'>"
				+  neatenSessionContentInit(tcontents)
				+ "</div><div class='panel-footer clearfix'><div style='float: right'><span class='glyphicon glyphicon-user'></span><a href='user.jsp' title='作者' target='_blank'>"
				+ uname
				+ "</a></div></div></div></li>";
				
		
		return newContents;
	}
	/**
	 * 重新设置<p></p>里面的内容，把图片隐藏起来
	 */
	@Override
	public String neatenSessionContentInit(String tcontents){
		List<String> imgSrcs = getImageAndContent(tcontents);
		/*重新设置<p></p>里面的内容，把图片隐藏起来*/
		
		StringBuilder newContentsInit =new StringBuilder("<div>");
		newContentsInit.append(tcontents.replaceAll("style=", "styleOld=").replaceAll("<img ", "<img style='display:none;' ").replaceAll("<p>", "").replaceAll("</p>","").replaceAll("<br>",""));
		newContentsInit.append("</div>");
		/*把图片加在后面*/
		for(int i=0,j=0;i<imgSrcs.size()&j<3;i++,j++){
			newContentsInit.append("<img "+imgSrcs.get(i)+" width='137px' height='137' >");
		}
		
		return newContentsInit.toString();
	}
	/*获得图像的src*/
	private List<String> getImageAndContent(String tcontents){
		 List<String> imgSrc = new ArrayList<String>();//图像的src
		 String regex = "src=\"\\S*\"";//图像的正则
		 Pattern p = Pattern.compile(regex);
	     Matcher m = p.matcher(tcontents); // 获取 matcher 对象
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
		 //该topic的所有回帖
		 PageMode<ReplyView> allReply = queryReplyViewPageMode(1, 5, topic.getTid());
		 //和该topic相似的topics
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
