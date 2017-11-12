package service.iService;

import java.util.List;

import entity.viewEntity.TopicView;
import entity.viewEntity.SessionView;


public interface ISessionViewService {

	/**
	 * ��ѯsession view
	 * @param sid
	 * @return
	 */
	SessionView querySessionView(String sid);

	/**
	 * �����������ӵ�����
	 * ������ʾ��session��
	 * @param TopicViews
	 */
	void setTopicViewContents(List<TopicView> TopicViews);

}
