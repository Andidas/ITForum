package entity;

import java.util.List;

/**
 * @author lwy
 *	Ҫ��ʾ��topic����Ķ���
  * @param topic //��ǰtopic��ȫ����Ϣ
	 * @param sessionName // topic��Ӧ��session��
	 * @param userName	//��Ӧ��user��
	 * @param lastReplyUserName //���һ���ظ����û���
	 * @param sameTopic  // ��ͬtopic
 */
public class TopicView {
	public TopicView(Topic topic, String sessionName, String userName,
			String lastReplyUserName, List<Topic> sameTopic) {
		super();
		this.topic = topic;
		this.sessionName = sessionName;
		this.userName = userName;
		this.lastReplyUserName = lastReplyUserName;
		this.sameTopic = sameTopic;
	}
	public TopicView() {
		super();
		
	}
	private Topic topic;
	private String sessionName;
	private String userName;
	private String lastReplyUserName;
	private List<Topic> sameTopic;
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public String getSessionName() {
		return sessionName;
	}
	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLastReplyUserName() {
		return lastReplyUserName;
	}
	public void setLastReplyUserName(String lastReplyUserName) {
		this.lastReplyUserName = lastReplyUserName;
	}
	public List<Topic> getSameTopic() {
		return sameTopic;
	}
	public void setSameTopic(List<Topic> sameTopic) {
		this.sameTopic = sameTopic;
	}
	@Override
	public String toString() {
		return "TopicView [topic=" + topic + ", sessionName=" + sessionName
				+ ", userName=" + userName + ", lastReplyUserName="
				+ lastReplyUserName + ", sameTopic=" + sameTopic + "]";
	}
}
