package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import entity.PageMode;
import entity.ReplyView;
import entity.TopicView;
import service.ReplyService;
import service.SessionService;
import service.TopicService;

/**
 * topic
 * @author lwy
 *
 */
public class TopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*实例化业务类*/
	private TopicService ts = new TopicService();
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
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void toTopic(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		//帖子名
		String topicTName = request.getParameter("TopicTName");
		String sid = request.getParameter("sessionSid");
		//当前被选中的帖子de视图
		TopicView topicView = ts.getTopicViewOne(topicTName,sid);
		
		if(topicView==null){
			out.print("<script>alert('帖子不存在');history.back();</script>");
		}else{
			ts.updateClickCount(topicTName);
			request.setAttribute("nowActiveTopicView", topicView);
			request.setAttribute("ReplyPage", topicView.getAllReply());
			request.getRequestDispatcher("topic.jsp").forward(request,response);
		}
	}
	/**
	 * topic的回帖
	 */
	private void findReplyByPage(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException  {
		PrintWriter out = response.getWriter();
		int pageno=1;
		String pagenoStr = request.getParameter("pageno");
		if(pagenoStr!=null&&!"".equals(pagenoStr)){
			pageno = Integer.parseInt(pagenoStr);
		}
		String nowTopicTid = request.getParameter("nowTopicTid");
		PageMode<ReplyView> pm = ts.queryReplyViewPageMode(pageno, 5, Integer.parseInt(nowTopicTid));
		if(pm==null){
			out.print("false");
		}else{
			List<ReplyView> replyViewList = pm.getData();
			JSONArray ja = new JSONArray();
			for(ReplyView rv : replyViewList){
				//把java对象转化成json对象
				JSONObject jo = JSONObject.fromObject(rv);
				ja.add(jo);
			}
			out.print(ja);
		}		
	}
	/**
	 * 发布topic，ajax
	 */
	private void releaseTopic(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		SessionService sessionService =new SessionService();
		PrintWriter out = response.getWriter();
		/*获得参数*/
		String sname = request.getParameter("sname");
		String uname = request.getParameter("uname");
		String ttopic = request.getParameter("ttopic");
		String tcontents = request.getParameter("tcontents");
		/*传递参数*/
		if(ts.addTopic(sname, uname, ttopic, tcontents)&sessionService.addSessionStopiccount(sname)){		
			String newContents = ts.neatenSessionContent(uname, ttopic, tcontents);
		
			out.print(newContents);	
		}else{
			out.print("false");			
		}
		
		
	}

}
