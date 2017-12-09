package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.FollowService;
import service.PrivateLetterService;
import service.ReplyService;
import service.SessionService;
import service.TopicService;
import service.UserService;
import utils.ConstantsData;
import utils.TransformTime;
import entity.PageMode;
import entity.PageParam;
import entity.Reply;
import entity.Topic;
import entity.User;
import entity.viewEntity.FollowView;
public class AboutUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FollowService followService = new FollowService();
    private SessionService sessionService = new SessionService();
    private ReplyService replyService = new ReplyService();
	private UserService userService = new UserService();
	private TopicService topicService = new TopicService();
	
	private PrivateLetterService pls = new PrivateLetterService();
    public AboutUserInfo() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if(op.equals("toInfoCenter")){
			toInfoCenter(request, response);
		}else if(op.equals("toUserInfo")){
			toUserInfo(request,response);
		}
	}
	
	
	private void toUserInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		User user = userService.queryUserOne(uid);
		List<FollowView> follows= followService.queryFollowList(uid);
		PageMode<Topic>topics = topicService.queryUserAllTopic(ConstantsData.PAGENO,ConstantsData.PAGESIZE_10,uid);
		PageMode<Reply>replys = replyService.queryUserAllReply(ConstantsData.PAGENO,ConstantsData.PAGESIZE,uid);
		List<Map<String,Object>> created = sessionService.queryAllSessionByMaster(uid);
		
		request.setAttribute("userReplys", replys);
		request.setAttribute("sessionsCreatedByUser", created);
		request.setAttribute("queryUserInfo", user);
		request.setAttribute("userFollowSession", follows);
		request.setAttribute("userTopic", topics);
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}
	
	private void toInfoCenter(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		User user = userService.queryUserOne(uid);
		HttpSession session = request.getSession();
		User sender = (User)session.getAttribute("NowLoginUser");
		
		if(sender==null){
			response.getWriter().print("<script>alert('请先登录');location.href='UserServlet?op=toLogin';</script>");
		}else{
			PageParam param = new PageParam(ConstantsData.PAGENO,ConstantsData.PAGESIZE_10,sender.getUid());
			PageMode<Map<String, Object>> letters = pls.queryMyPrivateLetterList(param);
			transformTime(letters);
			if(letters!=null){
			System.err.println(user);
			request.setAttribute("queryUserInfo", user);
			request.setAttribute("letterList", letters);
			request.getRequestDispatcher("PrivateLetter.jsp").forward(request, response);
			}
		}
		
	}
	private static void transformTime(PageMode<Map<String, Object>> letters){
		for (Map<String, Object> m : letters.getData()) {
			String value = TransformTime.howLongFromNow(m.get("ptime").toString());
			m.put("ptime", value);
		}
	}
}
