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
	 * token令牌技术：用于防止重复提交的问题：
	 * 1、跳转到提交页面前先添加令牌
	 * 2、在提交页面中存储令牌
	 * 3、在提交方法中校验令牌
	 * 从而达到防止重复提交的功能
	 */
	private void toNewSession(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		//1、跳转到提交页面前先添加令牌
		request.getSession().setAttribute("token", System.currentTimeMillis()+"");
		response.sendRedirect("newSession.jsp");
		
	}
	
	private void doNewSession(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		SmartUpload su = upPicture(request,response);
		// 4、获取表单信息，包括文件的详细信息
		SmartRequest smRequest = su.getRequest();
		SmartFiles fs = su.getFiles();// 得到所有文件
		SmartFile f = fs.getFile(0);
		
		HttpSession session = request.getSession();
		String formToken = smRequest.getParameter("token");
		String sessionToken = (String)session.getAttribute("token");
		if(formToken==null||sessionToken==null||!formToken.equals(sessionToken)){
			response.getWriter().print("<script>alert('请不要重复提交');location.href='welcome'</script>");
		}else{
			String spicture = f.getFileName();
			String sname = smRequest.getParameter("sessionName");
			String sprofile = smRequest.getParameter("sessionSprofile");
			String sstatement = smRequest.getParameter("sessionBio");
			int smasterid = ((User)session.getAttribute("NowLoginUser")).getUid();
			if(!sessionService.addSession(sname,smasterid,sprofile,sstatement,spicture)){
				System.out.println("插入失败");
			}else{
				int sid = sessionService.querySessionID(sname);
				response.sendRedirect("Session?op=toSession&SessionSid="+sid);
			}
		}
		
		session.removeAttribute("token");
		
		
	}
	/**
	 * 上传图片
	 */
	private SmartUpload upPicture(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		// 1、创建SmartUpload，并初始化
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServletConfig(), request, response);

		// 2、配置文件格式、大小
		su.setAllowedFilesList("jpg,png,gif");
		su.setMaxFileSize(10 * 1024 * 1024); // 单个文件最大10M
		su.setTotalMaxFileSize(15 * 1024 * 1024); // 全部最大15M

		// 3、执行上传：把上传的文件保存到服务器的内存中
		try {
			su.upload();
		} catch (SecurityException e) {
			System.out.print("上传失败,文件格式不匹配或文件内容了指定大小");
		} catch (SmartUploadException e) {
			System.out.print("上传失败");
		}
		// 5、文件保存到服务器指定的路径下
		try {
			su.save("/files");
		} catch (SmartUploadException e) {
			System.out.print("保存失败！~");
		}
		return su;
		
	}
	private void toSession(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		
		String sid = request.getParameter("SessionSid");
		sessionService.updateSessionClickCount(sid);
		SessionView sessionView = sessionViewService.querySessionView(sid);
		
		if(sessionView==null){
			response.getWriter().print("<script>alert('版块不存在');history.back();</script>");
		}else{
			request.setAttribute("sessionPage", sessionView.getTopicViewPM());
			request.setAttribute("nowActiveSessionView", sessionView);
			request.getRequestDispatcher("session.jsp").forward(request, response);
		}
	}
	
	private void findTopicByPage(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException  {
		PrintWriter out = response.getWriter();
		int pageno=ConstantsData.PAGENO; //页数
		
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
