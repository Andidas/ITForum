package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.SessionService;
import service.SessionViewService;
import service.TopicService;
import service.TopicViewService;
import utils.ConstantsData;
import entity.PageMode;
import entity.Session;
import entity.Topic;
import entity.viewEntity.TopicView;

public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    TopicService topicService = new TopicService();
    TopicViewService topicviewService = new TopicViewService();
    SessionViewService svs = new SessionViewService();
    SessionService sessionService = new SessionService();
    public WelcomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");

		if(op==null||op.equals("")){
			main(request,response);
		}else if(op.equals("getSnameAndSid")){
			getSnameAndSid(request,response);
		}
	}

	private void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = 9;
		PageMode<TopicView> topicViewPageMode = topicviewService.TopicSplitPage(ConstantsData.PAGENO,ConstantsData.PAGESIZE,sid);
		List<String> profiles = sessionService.queryAllProfile();
		List<Topic> topics = topicService.queryHotsTopicList();
		svs.setTopicViewContents(topicViewPageMode.getData());
		request.setAttribute("HotsTopics", topics);
		request.setAttribute("welcomeProfiles", profiles);
		request.setAttribute("topicViewPageMode", topicViewPageMode);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	private void getSnameAndSid(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String profile = request.getParameter("profile");
		List<Session> sessions = sessionService.queryAllSessionByProfile(profile);
		if(sessions==null){
			out.print("false");
		}else{
			JSONArray ja = new JSONArray();
			for (Session session : sessions) {
				JSONObject jo = JSONObject.fromObject(session);
				ja.add(jo);
			}
			out.print(ja);
		}
			
	}

}
