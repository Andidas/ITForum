package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.impl.SessionDaoImpl;
import dao.impl.TopicDaoImpl;
import dao.impl.UserDaoImpl;
import entity.Topic;
import service.iService.ITopicService;

public class TopicService implements ITopicService {
	
	TopicDaoImpl tdi = new TopicDaoImpl();
	@Override
	public boolean addTopic(String sname, String uname, String ttopic,
			String tcontents) {
		
		UserDaoImpl udi = new UserDaoImpl();
		SessionDaoImpl sdi = new SessionDaoImpl();
		
		Topic topic = new Topic();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ttime = df.format(new Date());//获取注册时间
		
		int tuid = udi.queryUserIDByName(uname);//得到用户id
		topic.setTuid(tuid);
		int tsid = sdi.querySessionIDByName(sname);//得到session的id
		topic.setTsid(tsid);
		topic.setTtopic(ttopic);
		topic.setTcontents(tcontents);
		topic.setTtime(ttime);
		
		int result = tdi.addTopic(topic);
		
		return result>0;
	}

	@Override
	public String neatenSessionContent(String uname, String ttopic,
			String tcontents) {
		List<String> imgSrcs = getImageAndContent(tcontents);
		/*重新设置<p></p>里面的内容，把图片隐藏起来*/
		StringBuilder newContentsInit =new StringBuilder(tcontents.replaceAll("style=", "styleOld=").replaceAll("<img ", "<img style='display:none;' ").replaceAll("<p>", "<span>").replaceAll("</p>","</span>"));
		newContentsInit.append("</div>");
		/*把图片加在后面*/
		for(int i=0,j=0;i<imgSrcs.size()&j<3;i++,j++){
			newContentsInit.append("<img "+imgSrcs.get(i)+" width='137px';height='137' >");
		}
		
		
		String newContents = "<li><div class='col-xs-2'><div class='thumbsUp'><p title='回复条数'><span class='activeSpan'>0</span><span class='glyphicon glyphicon-comment'></span></p><p title='被赞数目'><span class='activeSpan'>0</span><span class='glyphicon glyphicon glyphicon-thumbs-up'></span></p><p title='观看人数'><span class='activeSpan'>0</span><span class='glyphicon glyphicon glyphicon glyphicon-eye-open'></span></p></div></div><div class='panel col-xs-10'><div class='panel-heading'><a href='topic.html'>"
				+ ttopic
				+ "</a></div><div class='panel-body'>"
				+ "<div>"+newContentsInit.toString()
				+ "</div><div class='panel-footer clearfix'><div style='float: right'><span class='glyphicon glyphicon-user'></span><a href='user.jsp' title='作者' target='_blank'>"
				+ uname
				+ "</a></div></div></div></li>";
				
		//System.out.println(newContents);
		return newContents;
	}
	/*获得图像的src*/
	public List<String> getImageAndContent(String tcontents){
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
	public List<Topic> queryTopicListByTSID(int tsid) {
		List<Topic> topicList = null;
		topicList = tdi.queryTopicListByTSID(tsid);
		return topicList;
	}
	
	
	

}
