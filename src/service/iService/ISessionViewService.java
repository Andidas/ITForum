package service.iService;

import entity.viewEntity.SessionView;


public interface ISessionViewService {

	/**
	 * ��ѯsession view
	 * @param sid
	 * @return
	 */
	SessionView querySessionView(String sid);


}
