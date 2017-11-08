package service;

import java.util.List;

import entity.Reply;
import entity.Topic;
import entity.TopicView;

/**
 * 要显示在topic界面的所有信息的service
 * @author lwy
 *
 */
public class TopicViewService {
	private TopicService topicService = new TopicService();
	private SessionService  sessionService = new SessionService();
	private UserService userService = new UserService();
	private ReplyService replyService = new ReplyService();
	
	public TopicView getTopicView(String topicTName){
		TopicView topicView = new TopicView();
		//当前被选中的帖子
		Topic topic = topicService.queryTopicOneByTopic(topicTName);
		
		//版块名称
		String sessionName = sessionService.querySessionNameBySID(topic.getTsid()); 
		//用户名
		String userName = userService.queryUserNameById(topic.getTuid());
		//最后一个回复的用户
		String lastReplyUserName = userService.queryUserNameById(topic.getTlastreplyuseid());
		//相同的topic
		List<Topic> sameTopic = topicService.queryTopicListByTSID(topic.getTsid());
		
		List<Reply> allReply = replyService.queryReplyListByRTID(topic.getTid());
		topicView.setTopic(topic);
		topicView.setSessionName(sessionName);
		topicView.setUserName(userName);
		topicView.setLastReplyUserName(lastReplyUserName);
		topicView.setSameTopic(sameTopic);
		topicView.setAllReply(allReply);
		return topicView;
	}
}
