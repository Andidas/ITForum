package servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartFiles;
import com.jspsmart.upload.SmartRequest;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import entity.PageMode;
import entity.User;
import entity.viewEntity.SessionView;
import entity.viewEntity.TopicView;
import service.JsonService;
import service.SessionService;
import service.SessionViewService;
import service.TopicViewService;
import utils.ConstantsData;
/**
 * session
 * @author lwy
 *
 */
public class SessionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private SessionService sessionService = new SessionService();
	private SessionViewService sessionViewService = new SessionViewService();
	private TopicViewService topicViewService = new TopicViewService();
	private JsonService js = new JsonService();
    public SessionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if(op.equals("toSession")){
			toSession(request,response);
		}else if(op.equals("findTopicByPage")){
			findTopicByPage(request,response);
		}else if(op.equals("doNewSession")){
			doNewSession(request,response);
		}else if(op.equals("toNewSession")){
			toNewSession(request,response);
		}
	}
	/**
	 * token���Ƽ��������ڷ�ֹ�ظ��ύ�����⣺
	 * 1����ת���ύҳ��ǰ���������
	 * 2�����ύҳ���д洢����
	 * 3�����ύ������У������
	 * �Ӷ��ﵽ��ֹ�ظ��ύ�Ĺ���
	 */
	private void toNewSession(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		//1����ת���ύҳ��ǰ���������
		request.getSession().setAttribute("token", System.currentTimeMillis()+"");
		response.sendRedirect("newSession.jsp");
		
	}
	
	private void doNewSession(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		SmartUpload su = upPicture(request,response);
		// 4����ȡ����Ϣ�������ļ�����ϸ��Ϣ
		SmartRequest smRequest = su.getRequest();
		SmartFiles fs = su.getFiles();// �õ������ļ�
		SmartFile f = fs.getFile(0);
		
		HttpSession session = request.getSession();
		String formToken = smRequest.getParameter("token");
		String sessionToken = (String)session.getAttribute("token");
		if(formToken==null||sessionToken==null||!formToken.equals(sessionToken)){
			response.getWriter().print("<script>alert('�벻Ҫ�ظ��ύ');location.href='welcome'</script>");
		}else{
			String spicture = f.getFileName();
			String sname = smRequest.getParameter("sessionName");
			String sprofile = smRequest.getParameter("sessionSprofile");
			String sstatement = smRequest.getParameter("sessionBio");
			int smasterid = ((User)session.getAttribute("NowLoginUser")).getUid();
			if(!sessionService.addSession(sname,smasterid,sprofile,sstatement,spicture)){
				System.out.println("����ʧ��");
			}else{
				int sid = sessionService.querySessionID(sname);
				response.sendRedirect("Session?op=toSession&SessionSid="+sid);
			}
		}
		
		session.removeAttribute("token");
		
		
	}
	/**
	 * �ϴ�ͼƬ
	 */
	private SmartUpload upPicture(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		// 1������SmartUpload������ʼ��
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServletConfig(), request, response);

		// 2�������ļ���ʽ����С
		su.setAllowedFilesList("jpg,png,gif");
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
		// 5���ļ����浽������ָ����·����
		try {
			su.save("/files");
		} catch (SmartUploadException e) {
			System.out.print("����ʧ�ܣ�~");
		}
		return su;
		
	}
	private void toSession(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		
		String sid = request.getParameter("SessionSid");
		sessionService.updateSessionClickCount(sid);
		SessionView sessionView = sessionViewService.querySessionView(sid);
		
		if(sessionView==null){
			response.getWriter().print("<script>alert('��鲻����');history.back();</script>");
		}else{
			request.setAttribute("sessionPage", sessionView.getTopicViewPM());
			request.setAttribute("nowActiveSessionView", sessionView);
			request.getRequestDispatcher("session.jsp").forward(request, response);
		}
	}
	
	private void findTopicByPage(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException  {
		PrintWriter out = response.getWriter();
		int pageno=ConstantsData.PAGENO; //ҳ��
		
		String pagenoStr = request.getParameter("pageno");
		if(pagenoStr!=null&&!"".equals(pagenoStr)){
			pageno = Integer.parseInt(pagenoStr);
		}
		String sid = request.getParameter("sessionSid");
		PageMode<TopicView> pm = topicViewService.TopicSplitPage(pageno, ConstantsData.PAGESIZE, Integer.parseInt(sid));
		if(pm==null){
			out.print("false");
		}else{
			out.print(js.toJSONArray(pm.getData()));
		}		
	}
	
}
