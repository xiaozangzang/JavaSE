package com.jstl;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyJstl extends SimpleTagSupport{
	private int num;//输出次数
	private String info;//输出内容
	private String var;//接收输出内容
	
	//标签的业务逻辑处理
	public void doTag() throws JspException, IOException {
		JspContext jc = getJspContext();
		PageContext pc = (PageContext)jc;
		JspWriter out = pc.getOut();
		var = info;
		for(int i = 0; i < num; i ++){
			out.println(info+"\n");
		}
	}


	public void setVar(String var) {
		this.var = var;
	}


	public void setNum(int num) {
		this.num = num;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
