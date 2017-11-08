package service;

import java.util.List;

import entity.Reply;
import entity.Topic;
import entity.TopicView;

/**
 * Ҫ��ʾ��topic�����������Ϣ��service
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
		//��ǰ��ѡ�е�����
		Topic topic = topicService.queryTopicOneByTopic(topicTName);
		
		//�������
		String sessionName = sessionService.querySessionNameBySID(topic.getTsid()); 
		//�û���
		String userName = userService.queryUserNameById(topic.getTuid());
		//���һ���ظ����û�
		String lastReplyUserName = userService.queryUserNameById(topic.getTlastreplyuseid());
		//��ͬ��topic
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
