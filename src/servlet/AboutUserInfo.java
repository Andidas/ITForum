package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AboutUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AboutUserInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if(op.equals("toInfoCenter")){
			toInfoCenter(request, response);
		}
	}

	private void toInfoCenter(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		request.getRequestDispatcher("InfoCenter.jsp").forward(request, response);
	}

}
