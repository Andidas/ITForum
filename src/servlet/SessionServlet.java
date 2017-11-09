package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.SessionView;
import service.SessionService;
import service.SessionViewService;

/**
 * session
 * @author lwy
 *
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionService sessionService = new SessionService();
	private SessionViewService sessionViewService = new SessionViewService();
    public SessionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if(op.equals("toSession")){
			toSession(request,response);
		}
	}

	private void toSession(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		//获得板块名
		String sessionName = request.getParameter("sessionName");
		
		if(sessionService.updateSessionClickCount(sessionName)){
			System.err.println("session："+sessionName+" 点击次数加1");
		}else{
			System.err.println("session："+sessionName+" 点击次数加0");
		}
		//get session's view info
		SessionView sessionView = sessionViewService.getSessionView(sessionName);
		
		request.setAttribute("nowActiveSessionView", sessionView);
		request.getRequestDispatcher("session.jsp").forward(request, response);
	}

}
