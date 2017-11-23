package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FollowService;

/**
 * @author lwy
 * 关注板块和取消关注
 */
public class FollowAndUnfollowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FollowService fs = new FollowService();
   
    public FollowAndUnfollowServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if(op.equals("follow")){
			sessionFollow(request,response);
		}else if(op.equals("unfollow")){
			sessionUnfollow(request,response);
		}else if(op.equals("isBeFollow")){
			isBeFollow(request,response);
		}
	}
	/**
	 * 是否被关注
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void isBeFollow(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String uid = request.getParameter("uid");
		String sid = request.getParameter("sid");
		if(fs.isBeFollow(uid, sid)){
			out.print("true");
		}else{
			out.print("false");
		}
	}
	private void sessionFollow(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String sid = request.getParameter("sessionSid");
		String uid = request.getParameter("nowUserID");
		PrintWriter out = response.getWriter();
		if(fs.addFollow(uid,sid)){
			out.print("true");
		}else{
			out.print("false");
		}
		
	}
	private void sessionUnfollow(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String sid = request.getParameter("sessionSid");
		String uid = request.getParameter("nowUserID");
		
		PrintWriter out = response.getWriter();
		if(fs.deleteFollow(uid,sid)){
			out.print("true");
		}else{
			out.print("false");
		}
	}

}
