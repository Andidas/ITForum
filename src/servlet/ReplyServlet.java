package servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ReplyService;



public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReplyService replyService = new ReplyService();
	
    public ReplyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if(op.equals("ReplyTopic")){
			ReplyTopic(request,response);
		}
	}

	private void ReplyTopic(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String nowTopicTid = request.getParameter("nowTopicTid");
		String nowSessionID = request.getParameter("nowSessionID");
		String nowUserID = request.getParameter("nowUserID");
		String replyText = request.getParameter("replyText");
		System.out.println(nowTopicTid);
		if(replyService.addReplyOne(nowTopicTid,nowSessionID,nowUserID,replyText)){
			out.print("true");	
		}else{
			out.print("false");
		}
	}

	

}
