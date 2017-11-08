package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.TopicView;
import service.SessionService;
import service.TopicService;
import service.TopicViewService;

public class TopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*实例化业务类*/
	TopicService ts = new TopicService();
    public TopicServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if(op.equals("releaseTopic")){
			releaseTopic(request,response);
		}else if(op.equals("toTopic")){
			toTopic(request,response);
		}
		
	}
	/**
	 * 跳转到topic
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void toTopic(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		TopicViewService topicViewService = new TopicViewService();
		PrintWriter out = response.getWriter();
		//帖子名
		String topicTName = request.getParameter("TopicTName");
		//当前被选中的帖子de视图
		TopicView topicView = topicViewService.getTopicView(topicTName);
		if(topicView==null){
			out.print("<script>alert('帖子不存在');history.back();</script>");
		}else{
			ts.updateClickCount(topicTName);
			request.setAttribute("nowActiveTopicView", topicView);
			
			request.getRequestDispatcher("topic.jsp").forward(request,response);
		}
	}
	
	/**
	 * 发布topic，ajax
	 */
	private void releaseTopic(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		SessionService sessionService =new SessionService();
		PrintWriter out = response.getWriter();
		/*获得参数*/
		String sname = request.getParameter("sname");
		String uname = request.getParameter("uname");
		String ttopic = request.getParameter("ttopic");
		String tcontents = request.getParameter("tcontents");
		/*传递参数*/
		if(ts.addTopic(sname, uname, ttopic, tcontents)&sessionService.addSessionStopiccount(sname)){		
			String newContents = ts.neatenSessionContent(uname, ttopic, tcontents);
		
			out.print(newContents);	
		}else{
			out.print("false");			
		}
		
		
	}

}
