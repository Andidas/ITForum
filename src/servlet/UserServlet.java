package servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");

		if (op.equals("login")) {
			login(request, response);
		} else if ("getPassword".equals(op)) {
			getPassword(request, response);
		} else if (op.equals("register")) {
			register(request, response);
		}
	}

	private void getPassword(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		Cookie[] cookies = request.getCookies();
		PrintWriter out = response.getWriter();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("Advance2")
					&& email.equals(cookie.getValue())) {
				String password = userService.queryUser(email).getUpassword();
				
				out.print(password);
			}
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		HttpSession session = request.getSession();
		if (userService.checkUser(email, password)) {
			if (rememberMe != null && rememberMe.equals("yes")) {
				Cookie c = new Cookie("Advance2", email);
				c.setMaxAge(7 * 24 * 60 * 60);
				response.addCookie(c);
			} else {
				Cookie c = new Cookie("Advance2", null);
				c.setMaxAge(0);
				response.addCookie(c);
				session.setAttribute("email", email);
			}
			response.sendRedirect("index.jsp");
		} else {
			Cookie c = new Cookie("Advance2", null);
			c.setMaxAge(0);
			response.addCookie(c);

			response.sendRedirect("loginAndRegister.jsp");
		}
	}

	private void register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("rname");
		String email = request.getParameter("remail");
		String password = request.getParameter("rpassword");
		String ensurePassword = request.getParameter("ensurePassword");
		PrintWriter out = response.getWriter();
		int result = userService.addUser(name, email, password, ensurePassword);
		if (result == 1) {
			out.print("<script>alert('两次密码不同');history.back();</script>");

		} else if (result == 2) {
			out.print("<script>alert('插入失败');history.back();</script>");

		} else if (result == 4) {
			out.print("<script>alert('新增成功');history.back();</script>");

		}

	}

}
