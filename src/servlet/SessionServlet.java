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
		
		//��ð����
		String sessionName = request.getParameter("sessionName");
		
		//���ڱ������session
		Session nowActiveSession = ss.searchSession(sessionName);
		
		//����session����������topic
		List<Topic> topicListBelongNowSession = ts.queryTopicListByTSID(nowActiveSession.getSid());
		for (Topic t : topicListBelongNowSession) {
			String newcontents = ts.neatenSessionContentInit(t.getTcontents());
			t.setTcontents(newcontents);
		}
		//session��ӵ����
		String nowSessionMaster = us.queryUserNameById(nowActiveSession.getSmasterid());
		
		//��ͬsprofile��session
		List<Session> sameSprofile = ss.querySessionByProfile(nowActiveSession.getSprofile());
		
		//�Ƴ�sessionName��session
		for (int i =0 ;i<sameSprofile.size();i++) {
			if(sameSprofile.get(i).getSname().equals(sessionName)){
				sameSprofile.remove(i);
			}
		}
		sameSprofile.remove(sessionName);
		//
		//System.out.println(topicListBelongNowSession);
		//���ò���
		request.setAttribute("sameSprofile", sameSprofile);
		request.setAttribute("nowSessionMaster", nowSessionMaster);
		request.setAttribute("nowActiveSession", nowActiveSession);
		request.setAttribute("topicListBelongNowSession", topicListBelongNowSession);
		
		request.getRequestDispatcher("session.jsp").forward(request, response);
	}

}
