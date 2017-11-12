package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.PageMode;
import entity.viewEntity.ReplyView;
import entity.viewEntity.TopicView;
import service.JsonService;
import service.TopicService;
import service.TopicViewService;

/**
 * topic
 * @author lwy
 *
 */
public class TopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 每页数据条数
	 */
	private static final int PAGESIZE =5; 
	/*实例化业务类*/
	private TopicService ts = new TopicService();
	private TopicViewService tvs = new TopicViewService();
	private JsonService js = new JsonService();
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
		}else if(op.equals("findReplyByPage")){
			findReplyByPage(request,response);
		}
		
	}
	/**
	 * 跳转到topic
	 */
	private void toTopic(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		String topicTid = request.getParameter("topicTid");
		String sid = request.getParameter("sessionSid");
		
		TopicView topicView = tvs.getTopicViewOne(topicTid,sid);
		
		if(topicView==null){
			response.getWriter().print("<script>alert('帖子不存在');history.back();</script>");
		}else{
			ts.updateClickCount(topicTid);
			request.setAttribute("nowActiveTopicView", topicView);
			request.setAttribute("ReplyPage", topicView.getAllReply());
			request.getRequestDispatcher("topic.jsp").forward(request,response);
		}
	}
	/**
	 * topic的回帖分页
	 */
	private void findReplyByPage(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException  {
		PrintWriter out = response.getWriter();
		int pageno=1; //页数
		
		String pagenoStr = request.getParameter("pageno");
		if(pagenoStr!=null&&!"".equals(pagenoStr)){
			pageno = Integer.parseInt(pagenoStr);
		}
		String nowTopicTid = request.getParameter("nowTopicTid");
		PageMode<ReplyView> pm = tvs.queryReplyViewPageMode(pageno, PAGESIZE, Integer.parseInt(nowTopicTid));
		if(pm==null){
			out.print("false");
		}else{
			out.print(js.toJSONArray(pm.getData()));
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
		if(ts.addTopic(tsid, tuid, ttopic, tcontents)){		
			String newContents = tvs.neatenSessionContentInit(tcontents);
			out.print(newContents);	
		}else{
			out.print("false");			
		}
		
		
	}

}
