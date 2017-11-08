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
 * @author ��ΰ��
 * ��֤ servlet
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
	 * ��֤�������֤���Ƿ���ȷ
	 */
	private void toCheckEmailCaptcha(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		//������session����֤��,emailCaptcha
		String emailCaptcha = (String)session.getAttribute("emailCaptcha");
		//��ҳ�洫������֤��,inputCaptcha
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
	 * ������֤,ajaxʵ��,�õ���֤��
	 * @throws ServletException,IOException 
	 * @throws GeneralSecurityException 
	 */
	private void emailCaptcha(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		String to = request.getParameter("remail");//�õ�ע���email
		String Captcha = authenticateService.emailCaptcha(to);//�õ������֤��
		if(Captcha!=null){
			//������֤��ɹ�
			out.print("true");
			session.setAttribute("emailCaptcha", Captcha);//��email��֤�뱣����session��
		}else{
			out.print("false");
			session.setAttribute("emailCaptcha", null);//���session�����email��֤��
		}
	}

}
