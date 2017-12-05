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

import entity.User;
import service.UserService;

/**
 * @author ��ΰ��
 * �û�servlet
 */
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
		} else if(op.equals("modifyPassword")){
			modifyPassword(request, response);
		} else if(op.equals("isNameExist")){
			isNameExist(request, response);
		}else if(op.equals("loginAtAjxa")){
			loginAtAjxa(request,response);
		}
	}

	/**
	 * �û����Ƿ����
	 */
	private void isNameExist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		
		if(userService.isNameExist(uname)){
			out.print("true");
		}else{
			out.print("false");			
		}
	}

	/**
	 * �޸�����
	 */
	private void modifyPassword(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String newpassword = request.getParameter("newpassword");
		String email = request.getParameter("remail");
		PrintWriter out = response.getWriter();
		if(userService.modifyPasswordByEmail(email, newpassword)){
			out.print("true");
		}else{
			out.print("false");
		}
		
	}

	/**
	 * �����û�
	 */
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
		if(uhead.equals("")){
			uhead = user.getUhead();
		}
		String uemail = smRequest.getParameter("userEmail");
		String ubirthady = smRequest.getParameter("userBirthday");
		String usatement = smRequest.getParameter("userBio");
		String usex = smRequest.getParameter("userSex");
		user = userService.updateUser(user.getUid(),uname,uhead,uemail,usex,ubirthady,usatement);
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
		
		response.sendRedirect("UserInFo?op=toUserInfo&uid="+user.getUid());

	}	

	/**
	 * �õ��û����룬��ajax�����Զ���д
	 */
	private void getPassword(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		User user = userService.queryUser(email);
		Cookie[] cookies = request.getCookies();
		PrintWriter out = response.getWriter();
		if(user!=null){
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(String.valueOf(user.getUid())+"itforum")
						&& email.equals(cookie.getValue())) {
					String password = userService.queryUser(email).getUpassword();
					out.print(password);
				}
			}
		}
	}

	/**
	 * ��ת����¼ҳ�棬������ת֮ǰ��ҳ��url
	 */
	private void toLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = request.getHeader("REFERER");
		HttpSession session = request.getSession();
		session.setAttribute("toLoginURL", url);
		response.sendRedirect("loginAndRegister.jsp");
	}

	/**
	 * �û���¼��cookie����
	 */
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");//����
		String password = request.getParameter("password");//����
		String rememberMe = request.getParameter("rememberMe");//�Ƿ��ס��
		HttpSession session = request.getSession();
		String url = (String) session.getAttribute("toLoginURL");//���ĸ�ҳ�����ĵ�¼
		if (userService.checkUser(email, password)) {
			User user = userService.queryUser(email);
			user.setUpassword("***");//���뱣��
			if (rememberMe != null && rememberMe.equals("yes")) {
				Cookie c = new Cookie(String.valueOf(user.getUid())+"itforum", email);//��email���û���������Cookie
				c.setMaxAge(7 * 24 * 60 * 60);
				response.addCookie(c);
			} else {
				Cookie c = new Cookie(String.valueOf(user.getUid())+"itforum", null);
				c.setMaxAge(0);
				response.addCookie(c);
			}
			session.setAttribute("NowLoginUser", user);
			response.sendRedirect(url);
		} else {
			session.setAttribute("NowLoginUser", null);
			response.sendRedirect("loginAndRegister.jsp");
		}
	}
	private void loginAtAjxa(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");//����
		String password = request.getParameter("password");//����
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if (userService.checkUser(email, password)) {
			User user = userService.queryUser(email);
			session.setAttribute("NowLoginUser", user);
			out.print("true");
		}else{
			session.setAttribute("NowLoginUser", null);
			out.print("false");
		}
	}
	/**
	 * �˳��û�
	 */
	private void exitUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = request.getHeader("REFERER");// ���ݹ����ĵ�ַ����������
		session.setAttribute("NowLoginUser", null);
		response.sendRedirect(url);
	}

	/**
	 * �û�ע��
	 */
	private void register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		String name = request.getParameter("rname");
		String email = request.getParameter("remail");
		String password = request.getParameter("rpassword");
		PrintWriter out = response.getWriter();
		boolean result = userService.addUser(name, email, password);
		if (!result) {
			out.print("<script>alert('����ʧ��');history.back();</script>");
		} else {
			out.print("<script>alert('�����ɹ�');history.back();</script>");
			session.setAttribute("emailCaptcha", null);
		}

	}

}
