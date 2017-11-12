package service.iService;

import java.util.List;

import entity.viewEntity.TopicView;
import entity.viewEntity.SessionView;


public interface ISessionViewService {

	/**
	 * 查询session view
	 * @param sid
	 * @return
	 */
	SessionView querySessionView(String sid);

	/**
	 * 重新排列帖子的内容
	 * 用于显示在session中
	 * @param TopicViews
	 */
	void setTopicViewContents(List<TopicView> TopicViews);

}
