package com.entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException; // import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.java2d.loops.DrawLine;

/**
 * 输出随机的验证码
 */
//@WebServlet({ "/CheckCode", "/checkCode.jpg" })
public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/* 宽度 */
	private final int WIDTH = 100;
	/* 高度 */
	private final int HEIGHT = 20;
	/* 生成验证码的个数 */
	private final int COUNT = 4;
	/* 干扰线条数 */
	private final int LINE_ROW = 6;

	/* 输出的基本码表，如果使用中文，则使用utf-8的码表，类似 \ue234 ，而且应该使用常用字，避免出现偏僻字 */
	private final char[] BASECODE = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
			'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
			'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
			'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9' };

	// 写出数据
	private void write(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		HttpSession session = request.getSession();

		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();

		setBackground(graphics);
		drawBorder(graphics);
		drawDot(graphics);
		drawLine(graphics);
		drawString(graphics, session);

		// 写出数据流
		ImageIO.write(image, "jpg", response.getOutputStream());

	}

	// 写字
	private void drawString(Graphics graphics, HttpSession session) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();

		graphics.setFont(new Font("宋体", Font.BOLD, 18));
		graphics.setColor(Color.BLACK);

		for (int i = 0; i < COUNT; i++) {
			String ch = String
					.valueOf(BASECODE[random.nextInt(BASECODE.length)]);
			sb.append(ch);

			// 设置位置
			int x = i * 20 + random.nextInt(12) + 10;
			int y = random.nextInt(HEIGHT / 3) + 12;

			// 旋转字体
			double theta = Math.PI / 180 * random.nextInt(20);
			// rotate(graphics, theta);

			graphics.drawString(ch, x, y);

			// 恢复。。
			// rotate(graphics, -theta);
		}
		session.setAttribute("checkCodeServlet", sb.toString());

		System.out.println("session:" + session + "   验证码：" + sb.toString());
	}

	// 旋转
	private void rotate(Graphics graphics, double theta) {
		((Graphics2D) graphics).rotate(theta);
	}

	// 画随机线条
	private void drawLine(Graphics graphics) {
		Random random = new Random();
		for (int i = 0; i < LINE_ROW; i++) {
			int x1 = random.nextInt(WIDTH);
			int y1 = random.nextInt(HEIGHT);
			int x2 = random.nextInt(WIDTH);
			int y2 = random.nextInt(HEIGHT);
			setRandomColor(graphics);
			graphics.drawLine(x1, y1, x2, y2);
		}
	}

	// 画斑点
	private void drawDot(Graphics graphics) {
		Random random = new Random();
		graphics.setColor(Color.red);
		for (int i = 0; i < WIDTH; i++) {
			int x = i;
			int y = random.nextInt(HEIGHT);
			int r = random.nextInt(2);
			// graphics.fillOval(x, y, r, r);
			graphics.drawOval(x, y, r, r);
		}
	}

	// 画边框
	private void drawBorder(Graphics graphics) {
		graphics.setColor(Color.BLACK);
		graphics.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);
	}

	// 设置背景
	private void setBackground(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);// 填充背景色
	}

	// 设置随机的画笔颜色
	private void setRandomColor(Graphics g) {
		Random random = new Random();
		g.setColor(new Color(random.nextInt(255), random.nextInt(255), random
				.nextInt(255)));
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 输出图片流的头信息
		response.setContentType("image/jpeg");
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control", "no-cache");

		// 写出数据
		write(request, response);

	}

//	protected void doGet(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//
//		// 输出图片流的头信息
//		response.setContentType("image/jpeg");
//		response.setHeader("Expires", "-1");
//		response.setHeader("Cache-Control", "no-cache");
//
//		// 写出数据
//		write(request, response);
//
//	}
//
//	protected void doPost(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

}
