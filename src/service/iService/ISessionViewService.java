package service.iService;

import entity.viewEntity.SessionView;


public interface ISessionViewService {

	/**
	 * session view
	 * @param sid
	 * @return
	 */
	SessionView querySessionView(String sid);


}
