package factory;

import service.AuthenticateService;
import service.FollowService;
import service.JsonService;
import service.ReplyService;
import service.SessionService;
import service.SessionViewService;
import service.TopicService;
import service.TopicViewService;
import service.UserService;
import service.iService.IAuthenticateService;
import service.iService.IFollowService;
import service.iService.IJsonService;
import service.iService.IReplyService;
import service.iService.ISessionService;
import service.iService.ISessionViewService;
import service.iService.ITopicService;
import service.iService.ITopicViewService;
import service.iService.IUserService;

/**
 * @author lwy
 * service π§≥ß¿‡
 */
public class ServiceFactory {

	public static IJsonService getJsonService(){
		return new JsonService();
	}
	public static IFollowService getFollowService(){
		return new FollowService();
	}
	public static IAuthenticateService getAuthenticateService(){
		return new AuthenticateService();
	}
	public static IReplyService getReplyService(){
		return new ReplyService();
	}
	public static ISessionService getSessionService(){
		return new SessionService();
	}
	public static ISessionViewService getSessionViewService(){
		return new SessionViewService();
	}
	public static ITopicService getTopicService(){
		return new TopicService();
	}
	public static ITopicViewService getTopicViewService(){
		return new TopicViewService();
	}
	public static IUserService getUserService(){
		return new UserService();
	}
}
