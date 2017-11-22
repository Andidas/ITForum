package servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TopicDao;
import dao.factory.DaoFactory;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.JsonService;
import service.SessionService;
import service.TopicService;
import service.TopicViewService;
import utils.ConstantsData;
import utils.ConstantsData.EnumDaoFactory;
import entity.PageMode;
import entity.PageParam;
import entity.Session;
import entity.Topic;
import entity.viewEntity.TopicView;

public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TopicViewService topicViewService;
	private TopicService topicService = new TopicService();
	private TopicViewService topicviewService = new TopicViewService();
	private SessionService sessionService = new SessionService();
	private JsonService js = new JsonService();
	private TopicDao topicDao = DaoFactory.getInstance(EnumDaoFactory.TOPIC).getTopicDao();

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
		}else if(op.equals("findTopicByPage")){
			findTopicByPage(request,response);
		}
	}

	private void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PageMode<TopicView> topicViewPageMode = topicviewService.TopicSplitPage(ConstantsData.PAGENO,ConstantsData.PAGESIZE);
		List<String> profiles = sessionService.queryAllProfile();
		List<Topic> topics = topicService.queryHotsTopicList();
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
	private void findTopicByPage(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException  {
		PrintWriter out = response.getWriter();
		int pageno=ConstantsData.PAGENO; //Ò³Êý
		
		String pagenoStr = request.getParameter("pageno");
		if(pagenoStr!=null&&!"".equals(pagenoStr)){
			pageno = Integer.parseInt(pagenoStr);
		}
		
		PageMode<TopicView> pm = new TopicViewService().TopicSplitPage(pageno, ConstantsData.PAGESIZE);
		
		if(pm==null){
			out.print("false");
		}else{
			out.print(js.toJSONArray(pm.getData()));
		}		
	}
}


