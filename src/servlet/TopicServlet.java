package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SessionService;
import service.TopicService;

public class TopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public TopicServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*实例化业务类*/
		TopicService topicService = new TopicService();
		PrintWriter out = response.getWriter();
		/*获得参数*/
		String sname = request.getParameter("sname");
		String uname = request.getParameter("uname");
		String ttopic = request.getParameter("ttopic");
		String tcontents = request.getParameter("tcontents");
		/*传递参数*/
		if(topicService.addTopic(sname, uname, ttopic, tcontents)){
			String newContents = topicService.neatenSessionContent(uname, ttopic, tcontents);
			out.print(newContents);			
		}else{
			out.print("false");
		}
	}

}
