package com.jstl;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyJstl extends SimpleTagSupport{
	private int num;//�������
	private String info;//�������
	private String var;//�����������
	
	//��ǩ��ҵ���߼�����
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
