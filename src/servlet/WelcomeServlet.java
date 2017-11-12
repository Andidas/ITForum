package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.PageMode;
import entity.viewEntity.TopicView;
import service.SessionViewService;
import service.TopicService;
import service.TopicViewService;

public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static int PAGENO = 1;//第几页
	private final static int PAGESIZE =5;//每页条数
    TopicService topicService = new TopicService();
    TopicViewService topicviewService = new TopicViewService();
    SessionViewService svs = new SessionViewService();
    public WelcomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = 9;
		PageMode<TopicView> topicViewPageMode = topicviewService.TopicSplitPage(PAGENO,PAGESIZE,sid);
		
		svs.setTopicViewContents(topicViewPageMode.getData());
		request.setAttribute("topicViewPageMode", topicViewPageMode);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
