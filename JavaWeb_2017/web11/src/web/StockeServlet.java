package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.JsonValueTimeProcess;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import entity.Card;
import entity.Stocke;

public class StockeServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		Random r = new Random();
		List<Stocke> lists = new ArrayList<Stocke>();
		Stocke s = new Stocke();
		s.setName("����"+r.nextInt(10000));
		s.setPrice(1.95*r.nextInt(10000));
		s.setTime(new Date());
		Card card = new Card("cardNo"+r.nextInt(10000));
		s.setCard(card);
		Stocke s1 = new Stocke();
		s1.setName("ũ��"+r.nextInt(10000));
		s1.setPrice(1.85*r.nextInt(10000));
		s1.setTime(new Date());
		Card card1 = new Card("cardNo"+r.nextInt(10000));
		s1.setCard(card1);
		lists.add(s);
		lists.add(s1);
		//�����ڽ��и�ʽ��
		//1.����ת��������
		JsonValueTimeProcess jvtp = new JsonValueTimeProcess();
		//2.����json���ö���
		JsonConfig jc = new JsonConfig();
		//3.ע��jsonת��
		jc.registerJsonValueProcessor(Date.class, jvtp);
		//��java����תΪjson�ַ�������Ӧ���ͻ��˵Ļص�������ʱ���ٽ�
		//json�ַ���תΪjson����
		//4.ʹ��ת���������ڽ���ת������Ϊjson�ַ���
		JSONArray ary = JSONArray.fromObject(lists, jc);
		System.out.println(ary.toString());
		pw.println(ary.toString());
	}
}


