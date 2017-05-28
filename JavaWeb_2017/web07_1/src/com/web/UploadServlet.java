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
        enctype�����ã������ñ����ݵ�MIME��������.
        MIME(�๦��internet�ʼ�����Э��),��Ĭ������£�enctype��ֵ��application/x-www-form-urlencoded,���
Ҫ�ϴ��ļ������뽫enctype���ó�multipart/form-data,��ʱ��������Ὣ�ļ�ֱ���Զ��������������͸������������������Ὣ���ݷ�װ��request�����С�
        step2 �ڷ������ˣ�����ʹ��request.getParameter()��ò���ֵ����Ӧ��ʹ��(InputStream)request.getInputStream()
        �����������Ȼ���������һ��ʹ�ù��� (apache commons-fileuploader.jar)��������

 * @author ��־��
 *
 */
public class UploadServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��װ�ϴ��Ľ�������
		PrintWriter pw = response.getWriter();
		//���ڴ����ļ�����һ����������
		DiskFileItemFactory dff = new DiskFileItemFactory();
		//��װ�ϴ������Ķ���
		ServletFileUpload sfu = new ServletFileUpload(dff);
		//�ϴ���  ����������ͨ�����·�ʽ��ȡ�ͻ������ݣ���Ҫͨ��InputStream��ȡ
//		String str = request.getParameter("userName");
//		pw.println("<h1>"+str+"</h1>");
		try {
			//��ȡȫ���ı���
			List<FileItem> list = sfu.parseRequest(request);
			//��list�����������ļ���Ŀ����ͨ�ı����Ƿ���ͨ�ı���
			for(int i = 0; i < list.size();i ++){
				FileItem item = list.get(i);
				if(item.isFormField()){//��ͨ�ı���
					String name = item.getFieldName();//�ı����name��
					String value = item.getString();//��ȡ�ı����ֵ
					pw.println("<h1> "+value+" </h1>");
				}else{//����ͨ�ı���
					//��ȡtomcat���ڵ�����·��
					ServletContext sc = getServletContext();
					String path = sc.getRealPath("upload");
					String name = item.getName();
					pw.println("<h1>"+path+"  " +name+ "</h1>");
					File file = new File(path+"/"+name);
					try {
						item.write(file);//�������ļ�д����������ָ����·������
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
