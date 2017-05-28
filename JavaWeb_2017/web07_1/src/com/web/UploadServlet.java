package com.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * step1   <form method="post"enctype="multipart/form-data">
        enctype的作用，是设置表单数据的MIME编码类型.
        MIME(多功能internet邮件传输协议),在默认情况下，enctype的值是application/x-www-form-urlencoded,如果
要上传文件，必须将enctype设置成multipart/form-data,此时，浏览器会将文件直接以二进制数据流发送给服务器。服务器不会将数据封装到request对象当中。
        step2 在服务器端，不能使用request.getParameter()获得参数值，而应该使用(InputStream)request.getInputStream()
        获得输入流，然后分析流。一般使用工具 (apache commons-fileuploader.jar)来分析。

 * @author 张志鹏
 *
 */
public class UploadServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//封装上传的解析内容
		PrintWriter pw = response.getWriter();
		//基于磁盘文件创建一个工厂对象
		DiskFileItemFactory dff = new DiskFileItemFactory();
		//封装上传解析的对象
		ServletFileUpload sfu = new ServletFileUpload(dff);
		//上传中  服务器不能通过以下方式获取客户端数据，需要通过InputStream读取
//		String str = request.getParameter("userName");
//		pw.println("<h1>"+str+"</h1>");
		try {
			//获取全部的表单项
			List<FileItem> list = sfu.parseRequest(request);
			//从list集合中区分文件条目是普通文本域还是非普通文本域
			for(int i = 0; i < list.size();i ++){
				FileItem item = list.get(i);
				if(item.isFormField()){//普通文本域
					String name = item.getFieldName();//文本域的name名
					String value = item.getString();//获取文本域的值
					pw.println("<h1> "+value+" </h1>");
				}else{//非普通文本域
					//获取tomcat所在的物理路径
					ServletContext sc = getServletContext();
					String path = sc.getRealPath("upload");
					String name = item.getName();
					pw.println("<h1>"+path+"  " +name+ "</h1>");
					File file = new File(path+"/"+name);
					try {
						item.write(file);//二进制文件写出到服务器指定的路径下面
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
