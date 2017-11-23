package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import entity.User;
public class AboutUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService = new UserService();

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
		}else if(op.equals("toUserInfo")){
			toUserInfo(request,response);
		}
	}

	/**
	 * 用户信息
	 */
	private void toUserInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		User user = userService.queryUserOne(uid);
		request.setAttribute("queryUserInfo", user);
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}
	
	private void toInfoCenter(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		request.getRequestDispatcher("InfoCenter.jsp").forward(request, response);
	}

}
