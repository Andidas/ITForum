package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import service.FollowService;
import service.JsonService;
import service.PrivateLetterService;
import service.TopicService;
import service.UserService;
import utils.ConstantsData;
import utils.TransformTime;
import entity.PageMode;
import entity.PageParam;
import entity.Topic;
import entity.User;
import entity.viewEntity.FollowView;
public class AboutUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FollowService followService = new FollowService();
	private UserService userService = new UserService();
	private TopicService topicService = new TopicService();
	private JsonService jsonService = new JsonService();
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
		}else if(op.equals("findUserTopic")){
			findUserTopic(request,response);
		}
	}
	private void findUserTopic(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException  {
		PrintWriter out = response.getWriter();
		int pageno=ConstantsData.PAGENO; 
		
		String pagenoStr = request.getParameter("pageno");
		if(pagenoStr!=null&&!"".equals(pagenoStr)){
			pageno = Integer.parseInt(pagenoStr);
		}
		String uid = request.getParameter("uid");
		PageMode<Topic> pm = topicService.queryUserAllTopic(pageno,ConstantsData.PAGESIZE_10,uid);
		if(pm.getData().size()==0){
			out.print("false");
		}else{
			JSONArray ja = jsonService.toJSONArray(pm.getData());
			out.print(ja);
		}		
	}
	/**
	 * �û���Ϣ
	 */
	private void toUserInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		User user = userService.queryUserOne(uid);
		List<FollowView> follows= followService.queryFollowList(uid);
		PageMode<Topic>topics = topicService.queryUserAllTopic(ConstantsData.PAGENO,ConstantsData.PAGESIZE_10,uid);
		
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
