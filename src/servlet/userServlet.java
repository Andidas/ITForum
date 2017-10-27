package servlet;

import java.io.IOException;


import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	
    public userServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String op = request.getParameter("op");
		if(op.equals("login")){
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			if(userService.checkUser(email, password)){
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				response.sendRedirect("login.jsp");
			}
		}else if(op.equals("register")){
			String name = request.getParameter("rname");
			String email = request.getParameter("remail");
			String password = request.getParameter("rpassword");
			String ensurePassword = request.getParameter("ensurePassword");
			PrintWriter out = response.getWriter();
			int result = userService.addUser(name,email,password,ensurePassword);
			if(result ==1){
				out.print("<script>alert('两次密码不同');history.back();</script>");
				
			}else if(result==2){
				out.print("<script>alert('插入失败');history.back();</script>");
				
			}else if(result ==4){
				out.print("<script>alert('新增成功');history.back();</script>");
				
			}
			
		}

	}

}
