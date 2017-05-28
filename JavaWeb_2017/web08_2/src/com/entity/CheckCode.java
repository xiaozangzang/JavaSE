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
		// 响应返回一张图片
		response.setContentType("image/jpeg");
		BufferedImage image = new BufferedImage(60, 20,
				BufferedImage.TYPE_INT_RGB);
		//通过image对象获得一支画笔
		Graphics g = image.getGraphics();
		Random r = new Random();
		//设置随机生成颜色
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		//画方框
		g.fillRect(0, 0, 60, 20);
		g.setColor(new Color(0,0,0));
		
		String value = String.valueOf(r.nextInt(99999));
		HttpSession session = request.getSession();
		session.setAttribute("code", value);
		//将value绘制到方框里面
		g.drawString(value, 5, 15);
		//绘制干扰线
		g.drawLine(r.nextInt(60), r.nextInt(20),r.nextInt(60),r.nextInt(20));
		g.drawLine(r.nextInt(60), r.nextInt(20),r.nextInt(60),r.nextInt(20));
		g.drawLine(r.nextInt(60), r.nextInt(20),r.nextInt(60),r.nextInt(20));
		g.drawLine(r.nextInt(60), r.nextInt(20),r.nextInt(60),r.nextInt(20));
		g.drawLine(r.nextInt(60), r.nextInt(20),r.nextInt(60),r.nextInt(20));
		//将绘制的图片进行压缩
		OutputStream os = response.getOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
		encoder.encode(image);
	}

}
