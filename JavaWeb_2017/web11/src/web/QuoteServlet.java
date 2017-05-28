package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuoteServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		PrintWriter pw = response.getWriter();
		if(path.equals("/quto")){
			String name = request.getParameter("objName");
			if(name.equals("car")){
				String str = "bm:±¦Âí;ad:°ÂµÏ;bc:±¼³Û;msld:ÂêÉ¯À­µÙ;bsj:±£Ê±½Ý";
				pw.println(str);
			}else{//ryp
				String str = "mj:Ã«½í;ys:ÑÀË¢;xyf:Ï´ÒÂ·Û;xfs:Ï´·¢Ë®";
				pw.print(str);
			}
		}
		
	}
}
