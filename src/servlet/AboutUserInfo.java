package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import service.FollowService;
import service.JsonService;
import service.TopicService;
import service.UserService;
import utils.ConstantsData;
import entity.PageMode;
import entity.Topic;
import entity.User;
import entity.viewEntity.FollowView;
import entity.viewEntity.ReplyView;
public class AboutUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FollowService followService = new FollowService();
	private UserService userService = new UserService();
	private TopicService topicService = new TopicService();
	private JsonService jsonService = new JsonService();
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
		int pageno=ConstantsData.PAGENO; //页数
		
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
	 * 用户信息
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
		request.getRequestDispatcher("NoticeUser.jsp").forward(request, response);
	}
	

}
