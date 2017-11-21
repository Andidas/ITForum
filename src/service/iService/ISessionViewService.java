package service.iService;

import entity.viewEntity.SessionView;


public interface ISessionViewService {

	/**
	 * ≤È—Øsession view
	 * @param sid
	 * @return
	 */
	SessionView querySessionView(String sid);


}
