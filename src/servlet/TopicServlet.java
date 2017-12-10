package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import service.JsonService;
import service.TopicService;
import service.TopicViewService;
import utils.ConstantsData;
import entity.PageMode;
import entity.Topic;
import entity.viewEntity.TopicView;

/**
 * topic
 * @author lwy
 *
 */
public class TopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*实例化业务类*/
	private JsonService jsonService = new JsonService();	 
	private TopicService topicService = new TopicService();
	private TopicViewService topicViewService = new TopicViewService();
	
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
		}else if(op.equals("findUserTopic")){
			findUserTopic(request,response);
		}else if(op.equals("deleteTopic")){
			deleteTopic(request,response);
		}
		
	}
	private void deleteTopic(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String tid = request.getParameter("tid");
		PrintWriter out = response.getWriter();
		if(topicService.deleteTopic(tid)){
			out.print("true");
		}else{
			out.print("false");
		}
	}
	/**
	 * 查询用户的topic分页
	 */
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
	 * 跳转到topic
	 */
	private void toTopic(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		String topicTid = request.getParameter("topicTid");
		String sid = request.getParameter("sessionSid");
		
		TopicView topicView = topicViewService.getTopicViewOne(topicTid,sid);
		
		if(topicView==null){
			response.getWriter().print("<script>alert('帖子不存在');history.back();</script>");
		}else{
			topicService.updateClickCount(topicTid);
			request.setAttribute("nowActiveTopicView", topicView);
			request.setAttribute("ReplyPage", topicView.getAllReply());
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
		String tsid = request.getParameter("tsid");
		String tuid = request.getParameter("tuid");
		String ttopic = request.getParameter("ttopic");
		String tcontents = request.getParameter("tcontents");
		/*传递参数*/
		if(topicService.addTopic(tsid, tuid, ttopic, tcontents)){		
			out.print("true");	
		}else{
			out.print("false");			
		}
		
		
	}

}