package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;

import javax.servlet.ServletException;
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
		}else if(op.equals("toCheckEmailCaptcha")){
			toCheckEmailCaptcha(request,response);
		}
	}

	/**
	 * 验证输入的验证码是否正确
	 */
	private void toCheckEmailCaptcha(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		//保存在session的验证码,emailCaptcha
		String emailCaptcha = (String)session.getAttribute("emailCaptcha");
		//从页面传来的验证码,inputCaptcha
		String inputCaptcha = request.getParameter("captcha");
		if(emailCaptcha!=null & inputCaptcha!=null){
			if(emailCaptcha.equals(inputCaptcha)){
				out.print("true");
			}
		}else{
			out.print("false");
		}
		
	}

	/**
	 * 邮箱验证,ajax实现,得到验证码
	 * @throws ServletException,IOException 
	 * @throws GeneralSecurityException 
	 */
	private void emailCaptcha(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		String to = request.getParameter("remail");//得到注册的email
		String Captcha = authenticateService.emailCaptcha(to);//得到随机验证码
		if(Captcha!=null){
			//发送验证码成功
			out.print("true");
			session.setAttribute("emailCaptcha", Captcha);//将email验证码保存在session中
		}else{
			out.print("false");
			session.setAttribute("emailCaptcha", null);//清空session里面的email验证码
		}
	}

}
