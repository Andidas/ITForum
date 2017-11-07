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
		String ttime = df.format(new Date());//��ȡע��ʱ��
		
		int tuid = udi.queryUserIDByName(uname);//�õ��û�id
		topic.setTuid(tuid);
		int tsid = sdi.querySessionIDByName(sname);//�õ�session��id
		topic.setTsid(tsid);
		topic.setTtopic(ttopic);
		topic.setTcontents(tcontents);
		topic.setTtime(ttime);
		
		int result = tdi.addTopic(topic);
		
		return result>0;
	}

	/**
	 * ��������<p></p>��������ݣ���ͼƬ��������
	 * @param tcontents
	 * @return
	 */
	public String neatenSessionContentInit(String tcontents){
		List<String> imgSrcs = getImageAndContent(tcontents);
		/*��������<p></p>��������ݣ���ͼƬ��������*/
		
		StringBuilder newContentsInit =new StringBuilder("<div>");
		newContentsInit.append(tcontents.replaceAll("style=", "styleOld=").replaceAll("<img ", "<img style='display:none;' ").replaceAll("<p>", "").replaceAll("</p>","").replaceAll("<br>",""));
		newContentsInit.append("</div>");
		/*��ͼƬ���ں���*/
		for(int i=0,j=0;i<imgSrcs.size()&j<3;i++,j++){
			newContentsInit.append("<img "+imgSrcs.get(i)+" width='137px';height='137' >");
		}
		
		return newContentsInit.toString();
	}
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
	/*���ͼ���src*/
	public List<String> getImageAndContent(String tcontents){
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
	public List<Topic> queryTopicListByTSID(int tsid) {
		List<Topic> topicList = null;
		topicList = tdi.queryTopicListByTSID(tsid);
		return topicList;
	}

	@Override
	public Topic queryTopicOneByTopic(String ttopic) {
		// TODO �Զ����ɵķ������
		return tdi.queryTopicOneByTopic(ttopic);
	}
	
	
	

}
