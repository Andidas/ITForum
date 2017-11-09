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
	/*ʵ����ҵ����*/
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
	 * ��ת��topic
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void toTopic(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		//������
		String topicTName = request.getParameter("TopicTName");
		String sid = request.getParameter("sessionSid");
		//��ǰ��ѡ�е�����de��ͼ
		TopicView topicView = ts.getTopicViewOne(topicTName,sid);
		
		if(topicView==null){
			out.print("<script>alert('���Ӳ�����');history.back();</script>");
		}else{
			ts.updateClickCount(topicTName);
			request.setAttribute("nowActiveTopicView", topicView);
			request.setAttribute("ReplyPage", topicView.getAllReply());
			request.getRequestDispatcher("topic.jsp").forward(request,response);
		}
	}
	/**
	 * topic�Ļ���
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
				//��java����ת����json����
				JSONObject jo = JSONObject.fromObject(rv);
				ja.add(jo);
			}
			out.print(ja);
		}		
	}
	/**
	 * ����topic��ajax
	 */
	private void releaseTopic(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		SessionService sessionService =new SessionService();
		PrintWriter out = response.getWriter();
		/*��ò���*/
		String sname = request.getParameter("sname");
		String uname = request.getParameter("uname");
		String ttopic = request.getParameter("ttopic");
		String tcontents = request.getParameter("tcontents");
		/*���ݲ���*/
		if(ts.addTopic(sname, uname, ttopic, tcontents)&sessionService.addSessionStopiccount(sname)){		
			String newContents = ts.neatenSessionContent(uname, ttopic, tcontents);
		
			out.print(newContents);	
		}else{
			out.print("false");			
		}
		
		
	}

}
