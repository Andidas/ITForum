package servlet;


import java.io.IOException;





import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Session;
import entity.SessionView;
import entity.Topic;
import service.SessionService;
import service.SessionViewService;
import service.TopicService;
import service.UserService;

public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SessionService ss = new SessionService();
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

		
		//��ð����
		String sessionName = request.getParameter("sessionName");
		
	
		if(ss.updateSessionClickCount(sessionName)){
			System.out.println("session��"+sessionName+" ���������1");
		}else{
			System.out.println("session��"+sessionName+" ���������0");
		}
		SessionViewService sessionViewService = new SessionViewService();
		SessionView sessionView = sessionViewService.getSessionView(sessionName);
		request.setAttribute("nowActiveSessionView", sessionView);
		System.out.println(sessionView);
		request.getRequestDispatcher("session.jsp").forward(request, response);
	}

}
