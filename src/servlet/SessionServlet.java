package servlet;


import java.io.IOException;





import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Session;
import entity.Topic;
import service.SessionService;
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
		TopicService ts = new TopicService();
		UserService us = new UserService();
		//获得板块名
		String sessionName = request.getParameter("sessionName");
		//现在被点击的session
		Session nowActiveSession = ss.searchSession(sessionName);
		//属于session的所有帖子topic
		List<Topic> topicListBelongNowSession = ts.queryTopicListByTSID(nowActiveSession.getSid());
		//session的拥有者
		String nowSessionMaster = us.queryUserNameById(9);
		System.out.println(nowSessionMaster);
		System.out.println(nowActiveSession);
		System.out.println(topicListBelongNowSession);
		//设置参数
		request.setAttribute("nowSessionMaster", nowSessionMaster);
		request.setAttribute("nowActiveSession", nowActiveSession);
		request.setAttribute("topicListBelongNowSession", topicListBelongNowSession);
		
		request.getRequestDispatcher("session.jsp").forward(request, response);
	}

}
