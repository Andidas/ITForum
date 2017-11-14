package servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.PageMode;
import entity.viewEntity.SessionView;
import entity.viewEntity.TopicView;
import service.JsonService;
import service.SessionService;
import service.SessionViewService;
import service.TopicViewService;

/**
 * session
 * @author lwy
 *
 */
public class SessionServlet extends HttpServlet {
	private final static int PAGESIZE = 5;
	private static final long serialVersionUID = 1L;
	private SessionService sessionService = new SessionService();
	private SessionViewService sessionViewService = new SessionViewService();
	private TopicViewService topicViewService = new TopicViewService();
	private JsonService js = new JsonService();
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
		}else if(op.equals("findTopicByPage")){
			findTopicByPage(request,response);
		}
	}

	private void toSession(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		
		String sid = request.getParameter("SessionSid");
		if(sessionService.updateSessionClickCount(sid)){
			System.out.println("sessionsid："+sid+" 点击次数加1");
		}else{
			System.out.println("sessionsid："+sid+" 点击次数加0");
		}
		SessionView sessionView = sessionViewService.querySessionView(sid);
		
		if(sessionView==null){
			response.getWriter().print("<script>alert('版块不存在');history.back();</script>");
		}else{
			request.setAttribute("sessionPage", sessionView.getTopicViewPM());
			request.setAttribute("nowActiveSessionView", sessionView);
			request.getRequestDispatcher("session.jsp").forward(request, response);
		}
	}
	
	private void findTopicByPage(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException  {
		PrintWriter out = response.getWriter();
		int pageno=1; //页数
		
		String pagenoStr = request.getParameter("pageno");
		if(pagenoStr!=null&&!"".equals(pagenoStr)){
			pageno = Integer.parseInt(pagenoStr);
		}
		String sid = request.getParameter("sessionSid");
		PageMode<TopicView> pm = topicViewService.TopicSplitPage(pageno, PAGESIZE, Integer.parseInt(sid));
		if(pm==null){
			out.print("false");
		}else{
			out.print(js.toJSONArray(pm.getData()));
		}		
	}
	
}
