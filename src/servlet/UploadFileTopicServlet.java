package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 文件的上传和下载
 * @author lwy
 *
 */
public class UploadFileTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UploadFileTopicServlet() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		String path = null;
		String path2 = null;
		 try {
		        List<FileItem> items = upload.parseRequest(request);
		       // System.out.println("1:=========" + items.size());
		        Map param = new HashMap();
		        for (Object object : items) {
		            FileItem fileItem = (FileItem) object;
		           // System.out.println("2:=========" + fileItem.toString());
		           // System.out.println("3fileItem.getFieldName():==" + fileItem.getFieldName());

		            if (fileItem.isFormField()) {
		                param.put(fileItem.getFieldName(), fileItem.getString("utf-8"));
		               // System.out.println("4: param.get(fileItem.getFieldName())===" + param.get(fileItem.getFieldName()));
		            } else {

		                String picturename =fileItem.getName();
		                path= getServletContext().getRealPath("/")+"files\\"+ picturename;
		               // System.out.println("======================="+path+"==========");
		                path2 = "files/" + picturename;
		                fileItem.write(new File(path));
		            }
		        }
		 } catch (Exception e) {
			e.printStackTrace();
		}
		 
		  PrintWriter out = response.getWriter();
		  out.print(path2);
		  
	}

}
