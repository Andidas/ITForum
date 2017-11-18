package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SessionService;
import service.TopicService;
import entity.Session;
import entity.Topic;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private TopicService topicService = new TopicService();
     private SessionService serssService = new SessionService();
     private SessionService sessionService = new SessionService();
   
    public SearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchText = request.getParameter("value");
		if(sessionService.isSearchSession(searchText)){
			searchSession(request,response,searchText);
		}else{
			searchTopic(request,response,searchText);
		}
		
		
	}
	
	private void searchTopic(HttpServletRequest request,
			HttpServletResponse response, String searchText) throws ServletException, IOException {
		List<Topic> topics = topicService.searchTopicAndContents(searchText);
		if(topics!=null){
			request.setAttribute("topics",topics);
			request.setAttribute("sessions",null);
		}else{
			request.setAttribute("topics",null);
		}
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}

	private void searchSession(HttpServletRequest request, HttpServletResponse response,String searchText) 
			throws ServletException, IOException{
		
		List<Session>sessions = serssService.searchSession(searchText);
		if(sessions!=null){
			request.setAttribute("sessions",sessions);
			request.setAttribute("topics",null);
		}else{
			request.setAttribute("sessions",null);
		}
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}
}
