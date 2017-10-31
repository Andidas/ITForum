package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.AuthenticateService;

/**
 * @author 刘伟艺
 * 验证 servlet
 */
public class AuthenticateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AuthenticateService  authenticateService = new AuthenticateService();
	
    public AuthenticateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("op");
		if(op.equals("emailCaptcha")){
			emailCaptcha(request,response);
		}
	}

	/**
	 * 邮箱验证,ajax实现
	 * @throws ServletException,IOException 
	 * @throws GeneralSecurityException 
	 */
	private void emailCaptcha(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String to = request.getParameter("email");
		String Captcha = authenticateService.emailCaptcha(to);
		if(Captcha!=null){
			out.print(Captcha);
			session.setAttribute("emailCaptcha", Captcha);
		}else{
			out.print("false");
			session.setAttribute("emailCaptcha", null);
		}
	}

}
