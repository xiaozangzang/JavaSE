package com.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.imageio.plugins.jpeg.JPEG;

public class CheckCode extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ��Ӧ����һ��ͼƬ
		response.setContentType("image/jpeg");
		BufferedImage image = new BufferedImage(60, 20,
				BufferedImage.TYPE_INT_RGB);
		//ͨ��image������һ֧����
		Graphics g = image.getGraphics();
		Random r = new Random();
		//�������������ɫ
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		//������
		g.fillRect(0, 0, 60, 20);
		g.setColor(new Color(0,0,0));
		
		String value = String.valueOf(r.nextInt(99999));
		HttpSession session = request.getSession();
		session.setAttribute("code", value);
		//��value���Ƶ���������
		g.drawString(value, 5, 15);
		//���Ƹ�����
		g.drawLine(r.nextInt(60), r.nextInt(20),r.nextInt(60),r.nextInt(20));
		g.drawLine(r.nextInt(60), r.nextInt(20),r.nextInt(60),r.nextInt(20));
		g.drawLine(r.nextInt(60), r.nextInt(20),r.nextInt(60),r.nextInt(20));
		g.drawLine(r.nextInt(60), r.nextInt(20),r.nextInt(60),r.nextInt(20));
		g.drawLine(r.nextInt(60), r.nextInt(20),r.nextInt(60),r.nextInt(20));
		//�����Ƶ�ͼƬ����ѹ��
		OutputStream os = response.getOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
		encoder.encode(image);
	}

}
