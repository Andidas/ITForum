package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.JsonService;
import service.PrivateLetterService;
import service.UserService;
import static utils.ConstantsData.*;
import entity.PageMode;
import entity.PageParam;
import entity.User;

public class PrivateLetterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrivateLetterService pls = new PrivateLetterService();
	private JsonService jsonService = new JsonService();
    public PrivateLetterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if(op.equals("letter_detail")){
			letter_detail(request,response);
		}else if(op.equals("send_letter")){
			send_letter(request,response);
		}else if(op.equals("new_letter")){
			new_letter(request,response);
		}
	}

	

	/**
	 * 新建私信
	 */
	private void new_letter(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String uname = request.getParameter("receiver");
		String ptouid = String.valueOf(new UserService().queryUserByName(uname));
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("NowLoginUser");
		String puid = String.valueOf(user.getUid());
		String pcontent = request.getParameter("body");
		if(pls.batchAdd(puid, ptouid, ORDINARY_MESSAGE, pcontent)){
			request.getRequestDispatcher("UserInFo?op=toInfoCenter&uid="+user.getUid()).forward(request, response);
		}else{
			response.getWriter().print("<script>alert('发送失败');history.back();</script>");
		}
	}

	/**
	 * 发送私信
	 */
	private void send_letter(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("NowLoginUser");
		String puid = String.valueOf(user.getUid());
		String ptouid = request.getParameter("receiver");
		String pcontent = request.getParameter("body");
		if(pls.batchAdd(puid, ptouid, ORDINARY_MESSAGE, pcontent)){
			request.getRequestDispatcher("UserInFo?op=toInfoCenter&uid="+user.getUid()).forward(request, response);
		}else{
			response.getWriter().print("<script>alert('发送失败');history.back();</script>");
		}
	}

	/**
	 * 详细对话信息
	 */
	private void letter_detail(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		User sender = (User)session.getAttribute("NowLoginUser");
		if(sender==null){
			out.print("false");
		}else{
			int friend_id = Integer.parseInt(request.getParameter("friend_id"));
			PageParam param = new PageParam(PAGENO,PAGESIZE_10,sender.getUid(),friend_id);
			PageMode<Map<String, Object>> detail_info = pls.queryMyPrivateLetterList_detail(param);
			if(detail_info==null){
				out.print("false");
			}else
			out.print(jsonService.toJSONArray(detail_info.getData()));
		}
		
	}
	
}