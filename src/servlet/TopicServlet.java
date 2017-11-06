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
	/*ʵ����ҵ����*/
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
	 * ��ת��topic
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void toTopic(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		//������
		String topicTName = request.getParameter("TopicTName");
		//��ǰ��ѡ�е�����
		Topic Topic = ts.queryTopicOneByTopic(topicTName);
		if(Topic==null){
			out.print("<script>alert('���Ӳ�����');history.back();</script>");
		}else{
			request.setAttribute("nowActiveTopic", Topic);
			request.getRequestDispatcher("topic.jsp").forward(request,response);
		}
	}
	/**
	 * ����topic��ajax
	 */
	private void releaseTopic(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		/*��ò���*/
		String sname = request.getParameter("sname");
		String uname = request.getParameter("uname");
		String ttopic = request.getParameter("ttopic");
		String tcontents = request.getParameter("tcontents");
		/*���ݲ���*/
		if(ts.addTopic(sname, uname, ttopic, tcontents)){
			String newContents = ts.neatenSessionContent(uname, ttopic, tcontents);
			out.print(newContents);			
		}else{
			out.print("false");
		}
		
	}

}
