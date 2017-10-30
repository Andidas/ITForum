package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartFiles;
import com.jspsmart.upload.SmartRequest;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.sun.corba.se.spi.activation.Repository;

import entity.User;
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
		} else if (op.equals("exitUser")) {
			exitUser(request, response);
		} else if (op.equals("toLogin")) {
			toLogin(request, response);
		} else if (op.equals("update")) {
			update(request, response);
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("NowLoginUser");
	
		// 1������SmartUpload������ʼ��
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServletConfig(), request, response);

		// 2�������ļ���ʽ����С
		su.setAllowedFilesList("jpg,txt,doc,png,gif,ini,java");
		su.setMaxFileSize(10 * 1024 * 1024); // �����ļ����10M
		su.setTotalMaxFileSize(15 * 1024 * 1024); // ȫ�����15M

		// 3��ִ���ϴ������ϴ����ļ����浽���������ڴ���
		try {
			su.upload();
		} catch (SecurityException e) {
			System.out.print("�ϴ�ʧ��,�ļ���ʽ��ƥ����ļ�������ָ����С");
		} catch (SmartUploadException e) {
			System.out.print("�ϴ�ʧ��");
		}
		// 4����ȡ����Ϣ�������ļ�����ϸ��Ϣ
		SmartRequest smRequest = su.getRequest();
		SmartFiles fs = su.getFiles();// �õ������ļ�
		SmartFile f = fs.getFile(0);
		String uname = smRequest.getParameter("userName");
		String uhead = f.getFileName();
		String uemail = smRequest.getParameter("userEmail");
		String ubirthady = smRequest.getParameter("userBirthday");
		String usatement = smRequest.getParameter("userBio");
		String usex = smRequest.getParameter("userSex");
		user = userService.modifyUser(user,uname,uhead,uemail,usex,ubirthady,usatement);
		if(user==null){
			System.out.println("user is empty");
		}
		session.setAttribute("NowLoginUser", user);

		// 5���ļ����浽������ָ����·����
		try {
			su.save("/files");
		} catch (SmartUploadException e) {
			System.out.print("����ʧ�ܣ�~");
		}
		
		response.sendRedirect("user.jsp");

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

	private void toLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = request.getHeader("REFERER");
		HttpSession session = request.getSession();
		session.setAttribute("toLoginURL", url);
		response.sendRedirect("loginAndRegister.jsp");
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		HttpSession session = request.getSession();
		String url = (String) session.getAttribute("toLoginURL");
		if (userService.checkUser(email, password)) {
			if (rememberMe != null && rememberMe.equals("yes")) {
				Cookie c = new Cookie("Advance2", email);
				c.setMaxAge(7 * 24 * 60 * 60);
				response.addCookie(c);
			} else {
				Cookie c = new Cookie("Advance2", null);
				c.setMaxAge(0);
				response.addCookie(c);
			}
			User user = userService.queryUser(email);
			session.setAttribute("NowLoginUser", user);
			response.sendRedirect(url);
		} else {
			Cookie c = new Cookie("Advance2", null);
			c.setMaxAge(0);
			response.addCookie(c);
			session.setAttribute("email", null);
			response.sendRedirect("loginAndRegister.jsp");
		}
	}

	private void exitUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = request.getHeader("REFERER");// ���ݹ����ĵ�ַ����������
		session.setAttribute("NowLoginUser", null);
		response.sendRedirect(url);
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
			out.print("<script>alert('�������벻ͬ');history.back();</script>");

		} else if (result == 2) {
			out.print("<script>alert('����ʧ��');history.back();</script>");

		} else if (result == 4) {
			out.print("<script>alert('�����ɹ�');history.back();</script>");

		}

	}

}
