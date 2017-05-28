package com.some;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamServlet  extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("text/html;charset=utf-8");
		Map<String,String[]> map = request.getParameterMap();
		Set<Entry<String,String[]>> set = map.entrySet();
		Iterator<Entry<String,String[]>> ite = set.iterator();
		PrintWriter pw = resp.getWriter();
		pw.println("¹þà¶!");
		while(ite.hasNext()){
			Entry<String,String[]> entry = ite.next();
			String key = entry.getKey();
			
			pw.println("key:"+key);
			String[] values = entry.getValue();
			for(String val : values){
				pw.println("value:"+val);
			}
		}
	}
}






