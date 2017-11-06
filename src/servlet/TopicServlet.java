package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Topic;
import service.SessionService;
import service.TopicService;

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
		PrintWriter out = response.getWriter();
		//帖子名
		String topicTName = request.getParameter("TopicTName");
		//当前被选中的帖子
		Topic Topic = ts.queryTopicOneByTopic(topicTName);
		if(Topic==null){
			out.print("<script>alert('帖子不存在');history.back();</script>");
		}else{
			request.setAttribute("nowActiveTopic", Topic);
			request.getRequestDispatcher("topic.jsp").forward(request,response);
		}
	}
	/**
	 * 发布topic，ajax
	 */
	private void releaseTopic(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		/*获得参数*/
		String sname = request.getParameter("sname");
		String uname = request.getParameter("uname");
		String ttopic = request.getParameter("ttopic");
		String tcontents = request.getParameter("tcontents");
		/*传递参数*/
		if(ts.addTopic(sname, uname, ttopic, tcontents)){
			String newContents = ts.neatenSessionContent(uname, ttopic, tcontents);
			out.print(newContents);			
		}else{
			out.print("false");
		}
		
	}

}
