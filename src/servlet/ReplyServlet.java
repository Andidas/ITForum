package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.JsonService;
import service.LzlReplyService;
import service.ReplyService;
import service.TopicViewService;
import utils.ConstantsData;
import entity.LzlReply;
import entity.PageMode;
import entity.Reply;
import entity.viewEntity.ReplyView;



/**
 * 
 * @author lwy
 *
 */
/**
 * @author Administrator
 *
 */
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReplyService replyService = new ReplyService();
	private JsonService jsonService = new JsonService();
	private TopicViewService topicViewService = new TopicViewService();
	private LzlReplyService lzlReplyService = new LzlReplyService();
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
		}else if(op.equals("findReplyByPage")){
			findReplyByPage(request,response);
		}else if(op.equals("findUserReply")){
			findUserReply(request,response);
		}else if(op.equals("deleteReply")){
			deleteReply(request,response);
		}else if(op.equals("addLzlReply")){
			addLzlReply(request,response);
		}else if(op.equals("findLzlReplyByPage")){
			findLzlReplyByPage(request,response);
		}
	}
	/**
	 * 查询楼中楼数据，根据rid
	 */
	private void findLzlReplyByPage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String rid = request.getParameter("rid");
		List<Map<String, Object>> lzlReplys= lzlReplyService.queryLzlReplyByLrid(rid);
		if(lzlReplys.size()>0)
			out.print(jsonService.toJSONArray(lzlReplys));
		else 
			out.print("false");
	}

	private void addLzlReply(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		String lrid = request.getParameter("rid");
		String content = request.getParameter("content");
		String luid = request.getParameter("uid");
		LzlReply lzl = lzlReplyService.insertLzlReply(lrid, luid, content);
		if(lzl.getLid()>0){
			out.print(JSONObject.fromObject(lzl));
		}else{
			out.print("false");
		}
	}

	private void deleteReply(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String rid = request.getParameter("rid");
		PrintWriter out = response.getWriter();
		if(replyService.deleteReply(rid))
			out.print("true");
		else
			out.print("false");
	}

	/**
	 * 用户的回帖分页
	 **/
	private void findUserReply(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		int pageno=ConstantsData.PAGENO; 
		
		String pagenoStr = request.getParameter("pageno");
		if(pagenoStr!=null&&!"".equals(pagenoStr)){
			pageno = Integer.parseInt(pagenoStr);
		}
		String uid = request.getParameter("uid");
		PageMode<Reply> pm =replyService.queryUserAllReply(pageno,ConstantsData.PAGESIZE,uid);
		if(pm.getData().size()==0){
			out.print("false");
		}else{
			JSONArray ja = jsonService.toJSONArray(pm.getData());
			out.print(ja);
		}		
	}
	/**
	 * 回复帖子
	 */
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
	/**
	 * topic的回帖分页
	 */
	private void findReplyByPage(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException  {
		PrintWriter out = response.getWriter();
		int pageno=ConstantsData.PAGENO; //页数
		
		String pagenoStr = request.getParameter("pageno");
		if(pagenoStr!=null&&!"".equals(pagenoStr)){
			pageno = Integer.parseInt(pagenoStr);
		}
		String nowTopicTid = request.getParameter("nowTopicTid");
		PageMode<ReplyView> pm = topicViewService.queryReplyViewPageMode(pageno, ConstantsData.PAGESIZE, Integer.parseInt(nowTopicTid));
		if(pm==null){
			out.print("false");
		}else{
			JSONArray ja = jsonService.toJSONArray(pm.getData());
			out.print(ja);
		}		
	}
	

}