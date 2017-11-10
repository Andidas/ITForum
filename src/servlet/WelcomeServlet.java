package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.PageMode;
import entity.ReplyView;
import entity.TopicView;
import service.SessionViewService;
import service.TopicService;
import service.TopicViewService;

public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
		PageMode<TopicView> topicViewPageMode = topicviewService.TopicSplitPage(1,5,9);
		
		svs.setTopicViewContents(topicViewPageMode.getData());
		request.setAttribute("topicViewPageMode", topicViewPageMode);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
